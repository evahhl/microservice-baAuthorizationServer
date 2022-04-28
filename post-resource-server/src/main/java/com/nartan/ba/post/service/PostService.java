package com.nartan.ba.post.service;

import com.nartan.ba.post.model.entity.Comment;
import com.nartan.ba.post.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author evahhl
 */
public interface PostService {

  Page<Post> getAll(Pageable pageable);

  Page<Post> getAllActive(Pageable pageable);

  Page<Post> getAllInactive(Pageable pageable);

  Page<Post> getByStatus(int status, Pageable pageable);

  Optional<Post> getById(int postId);

  Post add(Post post);

  Boolean edit(int postId, Post post);

  void addComment(int postId, Comment comment);

  Boolean deleteById(int postId);

  void like(int postId);
  
  void unLike(int postId);

  void likeComment(int postId, int commentId);
  
  void unLikeComment(int postId, int commentId);
  
  Boolean deleteCommentById(int postId, int commentId);
}
