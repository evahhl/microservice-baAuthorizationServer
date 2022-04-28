package com.nartan.ba.post.service.impl;

import com.nartan.ba.post.model.entity.Comment;
import com.nartan.ba.post.model.entity.Post;
import com.nartan.ba.post.repository.PostRepository;
import com.nartan.ba.post.service.PostService;
import com.nartan.ba.post.service.SequenceService;
import com.nartan.ba.post.util.Converter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.nartan.ba.post.util.Constants.ACTIVE;
import static com.nartan.ba.post.util.Constants.INACTIVE;

/**
 * @author evahhl
 */
public class PostServiceImpl implements PostService {

  private final Logger logger = LoggerFactory.getLogger(PostServiceImpl.class);

  private final PostRepository repository;
  private final SequenceService sequenceGenerator;
  private final MongoOperations mongoOperation;

  public PostServiceImpl(
      final PostRepository repository,
      final SequenceService sequenceGenerator,
      final MongoOperations mongoOperation
  ) {
    this.repository = repository;
    this.sequenceGenerator = sequenceGenerator;
    this.mongoOperation = mongoOperation;
  }

  @Override
  public Page<Post> getAll(final Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public Page<Post> getAllActive(final Pageable pageable) {
    return getByStatus(ACTIVE, pageable);
  }

  @Override
  public Page<Post> getAllInactive(final Pageable pageable) {
    return getByStatus(INACTIVE, pageable);
  }

  @Override
  public Page<Post> getByStatus(final int status, final Pageable pageable) {
    return repository.findByStatusEquals(status, pageable);
  }

  @Override
  public Optional<Post> getById(final int postId) {
    return repository.findByIdAndStatusEquals(postId, ACTIVE);
  }

  @Override
  public Post add(final Post post) {
    post.setId(sequenceGenerator.getNextSequenceId(Post.SEQUENCE));
    post.setComments(ImmutableList.of());
    post.setTags(ImmutableList.of());
    post.setDateCreated(new Date());
    post.setLikedBy(ImmutableSet.of());
    post.setStatus(ACTIVE);
    return repository.save(post);
  }

  @Override
  public Boolean edit(final int postId, Post post) {	
    return getById(postId)
            .map(postToUpdate -> {
                Query query = new Query(Criteria.where("_id").is(postId));
                Update update = new Update()
                		.set("post", post.getPost())
                		.set("description", post.getDescription())
                		.set("userId", post.getUserId())
                		.set("by", post.getBy());
                mongoOperation.findAndModify(query, update, Post.class);
                return Boolean.TRUE;
              }).orElse(Boolean.FALSE);
  }

  @Override
  public void addComment(final int postId, final Comment comment) {
    getById(postId).ifPresent(postToUpdate -> {
      comment.setId(sequenceGenerator.getNextSequenceId(Comment.SEQUENCE));
      comment.setDateCreated(new Date());
      comment.setLikedBy(ImmutableSet.of());

      Query query = new Query(Criteria.where("_id").is(postId));
      postToUpdate.getComments().add(comment);

      Update update = new Update().set("comments", postToUpdate.getComments());

      // This only modifies the comments and does not update the entire entity.
      mongoOperation.findAndModify(query, update, Post.class);
    });
  }

  @Override
  public Boolean deleteById(final int postId) {
    return getById(postId)
        .map(postToUpdate -> {
          Query query = new Query(Criteria.where("_id").is(postId));
          Update update = new Update().set("status", INACTIVE);
          mongoOperation.findAndModify(query, update, Post.class);
          return Boolean.TRUE;
        }).orElse(Boolean.FALSE);
  }

  @Override
  public void like(final int postId) {
    getById(postId)
        .filter(post -> !post.getLikedBy().contains(Converter.getCurrentUser()))
        .map(postToUpdate -> {
          Set<Integer> usersLiked = postToUpdate.getLikedBy();
          usersLiked.add(Converter.getCurrentUser());

          Query query = new Query(Criteria.where("_id").is(postId));
          Update update = new Update()
              .set("likes", postToUpdate.getLikes() + 1)
              .set("likedBy", usersLiked);

          return mongoOperation.findAndModify(query, update, Post.class);
        });
  }
  
  @Override
  public void unLike(final int postId) {
	 getById(postId)
        .filter(post -> post.getLikedBy().contains(Converter.getCurrentUser()))
        .map(postToUpdate -> {
          Set<Integer> usersLiked = postToUpdate.getLikedBy();
          usersLiked.remove(Converter.getCurrentUser());

          Query query = new Query(Criteria.where("_id").is(postId));
          Update update = new Update()
              .set("likes", postToUpdate.getLikes() - 1)
              .set("likedBy", usersLiked);

          return mongoOperation.findAndModify(query, update, Post.class);
        });
  	
  }

  @Override
  public void likeComment(final int postId, final int commentId) {
    // TODO: get userId from user service
    int fakeUserId = 2;

    getById(postId)
        .map(postToUpdate -> {
          List<Comment> comments = postToUpdate.getComments().stream()
              .peek(comment -> {
                if (comment.getId() == commentId) {
                  comment.setLikes(comment.getLikes() + 1);
                  Set<Integer> likedBy = comment.getLikedBy();
                  likedBy.add(fakeUserId);
                  comment.setLikedBy(likedBy);
                }
              }).collect(Collectors.toUnmodifiableList());

          Query query = new Query(Criteria.where("_id").is(postId));
          Update update = new Update().set("comments", comments);

          return mongoOperation.findAndModify(query, update, Post.class);
        });
  }



@Override
public void unLikeComment(int postId, int commentId) {
	// TODO Auto-generated method stub
	
}

@Override
public Boolean deleteCommentById(int postId, int commentId) {
	return getById(postId)
    .map(postToUpdate -> {
    	List<Comment> comments = (List<Comment>) postToUpdate.getComments().stream().collect(Collectors.toList());
    	
    	for(int i=0; i<comments.size(); i++) {
    		if(comments.get(i).getId()== commentId ) {
    			comments.remove(i);    			
    		}
    		
    	}

    	Query query = new Query(Criteria.where("_id").is(postId));
        Update update = new Update().set("comments", comments);

        mongoOperation.findAndModify(query, update, Post.class);
      return Boolean.TRUE;
    }).orElse(Boolean.FALSE);
}
}

