package com.nartan.ba.post.util;

import com.nartan.ba.post.model.dto.CommentDto;
import com.nartan.ba.post.model.dto.PostDto;
import com.nartan.ba.post.model.dto.TagDto;
import com.nartan.ba.post.model.entity.Comment;
import com.nartan.ba.post.model.entity.Post;
import com.nartan.ba.post.model.entity.Tag;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.nartan.ba.post.util.Constants.ACTIVE;

public class Converter {

  public static List<PostDto> postListToDtoList(final List<Post> postList) {
    return postList.stream()
        .map(Converter::toPostDtoFrom)
        .collect(Collectors.toUnmodifiableList());
  }

  public static PostDto toPostDtoFrom(final Post post) {
    return PostDto.builder()
        .id(post.getId())
        .userId(post.getUserId())
        .by(post.getBy())
        .post(post.getPost())
        .description(post.getDescription())
        .dateCreated(post.getDateCreated())
        .likes(post.getLikes())
        .comments(
            post.getComments().stream()
                .map(Converter::toCommentDtoFrom)
                .collect(Collectors.toUnmodifiableList()))
        .tags(
            post.getTags().stream()
                .map(Converter::toTagDtoFrom)
                .collect(Collectors.toUnmodifiableList()))
        .liked(isLikedByUser(post.getLikedBy())) // passing fake userId
        .build();
  }

  public static CommentDto toCommentDtoFrom(final Comment comment) {
    return CommentDto.builder()
        .id(comment.getId())
        .userId(comment.getUserId())
        .by(comment.getBy())
        .message(comment.getMessage())
        .dateCreated(comment.getDateCreated())
        .likes(comment.getLikes())
        .liked(isLikedByUser(comment.getLikedBy())) // passing fake userId
        .build();
  }

  public static TagDto toTagDtoFrom(final Tag tag) {
    return TagDto.builder()
        .id(tag.getId())
        .name(tag.getName())
        .build();
  }

  public static Post toPostFrom(final PostDto postDto) {
    Post post = new Post();

    post.setPost(postDto.post());
    post.setDescription(postDto.description());
    post.setBy(postDto.by());
    post.setUserId(postDto.userId());
    post.setTags(toTagListFrom(postDto.tags()));
    post.setStatus(ACTIVE);
    return post;
  }

  public static List<Tag> toTagListFrom(List<TagDto> tagDtoList) {
    return tagDtoList.stream()
        .map(Converter::toTagFrom)
        .collect(Collectors.toUnmodifiableList());
  }

  public static List<TagDto> toTagDtoListFrom(List<Tag> tagList) {
    return tagList.stream()
        .map(Converter::toTagDtoFrom)
        .collect(Collectors.toUnmodifiableList());
  }

  public static Tag toTagFrom(final TagDto tagDto) {
    Tag tag = new Tag();
    tag.setId(tagDto.id());
    tag.setName(tagDto.name());
    tag.setStatus(ACTIVE);

    return tag;
  }

  private static boolean isLikedByUser(final Set<Integer> userIdSet) {
    return userIdSet.contains(getCurrentUser());
  }
  
  public static int getCurrentUser() {
	  UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
              .getPrincipal();
	  String username = userDetails.getUsername();
	return Integer.parseInt(username);
  }
}
