package com.nartan.ba.post.controller.v1;

import com.nartan.ba.post.exceptions.PostNotFoundException;
import com.nartan.ba.post.model.dto.PageResponseDto;
import com.nartan.ba.post.model.dto.PostDto;
import com.nartan.ba.post.model.entity.Comment;
import com.nartan.ba.post.model.entity.Post;
import com.nartan.ba.post.service.PostService;
import com.nartan.ba.post.util.Converter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.nartan.ba.post.util.Constants.*;

/**
 * Controller for all v1 endpoints related to post.
 */
@RestController
@RequestMapping(value = "/v1/post", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PostController {

  private final PostService postService;

  @Autowired
  public PostController(final PostService postService) {
    this.postService = postService;
  }

  /**
   * Get all posts disregarding their status.
   *
   * @param page   The page number.
   * @param size   The page size.
   * @param sortBy The results sorted by this given field.
   * @return a {@link PageResponseDto<PostDto>} with all the posts found with given parameters.
   */
  @Operation(summary = "Get all posts disregarding their status.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Get all posts disregarding their status.",
          content = {@Content(mediaType = "application/json",
              schema = @Schema(implementation = PageResponseDto.class))})})
  @GetMapping("/all")
  public PageResponseDto<PostDto> getAll(
      @Parameter(description = "The page number to be retrieved. Default 0 as first page.")
      @RequestParam(defaultValue = FIRST_PAGE) final int page,
      @Parameter(description = "The page number to be retrieved. Default 0 as first page.")
      @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) final int size,
      @Parameter(description = "The page number to be retrieved. Default 0 as first page.")
      @RequestParam(defaultValue = SORT_BY_ID) final String sortBy
  ) {
    return createPageResponse(
        postService.getAll(PageRequest.of(page, size, Sort.by(sortBy).descending())));
  }

  /**
   * Get all active posts.
   *
   * @param page   The page number.
   * @param size   The page size.
   * @param sortBy The results sorted by this given field.
   * @return a {@link PageResponseDto<PostDto>} with all the active posts found with given
   * parameters.
   */
  @Operation(summary = "Get all active posts")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Get all active posts.",
          content = {@Content(mediaType = "application/json",
              schema = @Schema(implementation = PageResponseDto.class))})})
  @GetMapping("/all/active")
  public PageResponseDto<PostDto> getAllActive(
      @Parameter(description = "The page number to be retrieved. Default 0 as first page.")
      @RequestParam(defaultValue = FIRST_PAGE) final int page,
      @Parameter(description = "The page number to be retrieved. Default 0 as first page.")
      @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) final int size,
      @Parameter(description = "The page number to be retrieved. Default 0 as first page.")
      @RequestParam(defaultValue = SORT_BY_ID) final String sortBy
  ) {
    return createPageResponse(
        postService.getAllActive(PageRequest.of(page, size, Sort.by(sortBy).descending())));
  }

  /**
   * Get all inactive posts.
   *
   * @param page   The page number.
   * @param size   The page size.
   * @param sortBy The results sorted by this given field.
   * @return a {@link PageResponseDto<PostDto>} with all the inactive posts found with given
   * parameters.
   */
  @Operation(summary = "Get all inactive posts")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Get all inactive posts.",
          content = {@Content(mediaType = "application/json",
              schema = @Schema(implementation = PageResponseDto.class))})})
  @GetMapping("/all/inactive")
  public PageResponseDto<PostDto> getAllInactive(
      @Parameter(description = "The page number to be retrieved. Default 0 as first page.")
      @RequestParam(defaultValue = FIRST_PAGE) final int page,
      @Parameter(description = "The size of the page to be retrieved.")
      @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) final int size,
      @Parameter(description = "The results will be sorted by the given field.")
      @RequestParam(defaultValue = SORT_BY_ID) final String sortBy
  ) {
    return createPageResponse(
        postService.getAllInactive(PageRequest.of(page, size, Sort.by(sortBy).descending())));
  }

  /**
   * Get a post by its id.
   *
   * @param postId The id of the post to retrieve.
   * @return The {@link PostDto} found wit the given id.
   * @throws PostNotFoundException if no post is found with the given id.
   */
  @Operation(summary = "Get a post by its id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Post found with the given id.",
          content = {@Content(mediaType = "application/json",
              schema = @Schema(implementation = PostDto.class))}),
      @ApiResponse(responseCode = "404", description = "Post not found with the given id.",
          content = @Content)})
  @GetMapping("/{postId}")
  public PostDto getPostById(
      @Parameter(description = "The id of post to be retrieved.")
      @PathVariable("postId") final int postId) {
    return Converter.toPostDtoFrom(
        postService.getById(postId)
            .orElseThrow(() -> createPostNotFoundException(postId)));
  }

  /**
   * Creates a new post.
   *
   * @param post The {@link Post} to be created.
   * @return The {@link PostDto} created.
   */
  @Operation(summary = "Creates a new post.")
  @PostMapping(path = "/add")
  public PostDto addPost(@RequestBody final Post post) {
    return Converter.toPostDtoFrom(postService.add(post));
  }

  /**
   *
   * @param postId
   * @param post
   * @return
   */
  @Operation(summary = "Edit a post.")
  @PostMapping(path = "/{postId}/edit")
  public void editPost(@PathVariable final int postId, @RequestBody final Post post) {
	  if (!postService.edit(postId, post)) {
	      throw createPostNotFoundException(postId);
	    }
  }

  /**
   * Gives a like to a post.
   *
   * @param postId The id of the post to give the like.
   */
  @Operation(summary = "Gives a like to a post.")
  @PostMapping(path = "/{postId}/like")
  public void likePost(
      @Parameter(description = "The id of the post to give the like.")
      @PathVariable("postId") final int postId
  ) {
    postService.like(postId);
  }
  
  /**
   * Gives a like to a post.
   *
   * @param postId The id of the post to give the like.
   */
  @Operation(summary = "unlike to a post.")
  @PostMapping(path = "/{postId}/unlike")
  public void unlikePost(
      @Parameter(description = "The id of the post to give the like.")
      @PathVariable("postId") final int postId
  ) {
    postService.unLike(postId);
  }

  /**
   * Add a comment to a post.
   *
   * @param postId  The id of the post where the comment will be added.
   * @param comment The {@link Comment} to be added.
   */
  @Operation(summary = "Add a comment to a post.")
  @PostMapping(path = "/{postId}/comment/add")
  public void addCommentToPost(
      @Parameter(description = "The id of the post where the comment will be added.")
      @PathVariable("postId") final int postId,
      @RequestBody final Comment comment
  ) {
    postService.addComment(postId, comment);
  }

  /**
   * Gives a like to comment.
   *
   * @param postId    The id of the post that contains the comment to be liked.
   * @param commentId The id of the comment to be liked.
   */
  @Operation(summary = "Gives a like to comment.")
  @PostMapping(path = "/{postId}/comment/{commentId}/like")
  public void likeComment(
      @Parameter(description = "The id of the post that contains the comment to be liked.")
      @PathVariable("postId") final int postId,
      @Parameter(description = "The id of the comment to be liked.")
      @PathVariable("commentId") final int commentId
  ) {
    postService.likeComment(postId, commentId);
  }

  /**
   * Deletes a post by its id. This is a logical deletion by setting an inactive status.
   *
   * @param postId The id of the post to be deleted.
   * @throws PostNotFoundException if no post is found with the given id.
   */
  @Operation(summary = "Deletes a post by its id.")
  @DeleteMapping(path = "/delete/{postId}")
  public void deleteById(
      @Parameter(description = "The id of the post to be deleted.")
      @PathVariable("postId") final int postId
  ) {
    if (!postService.deleteById(postId)) {
      throw createPostNotFoundException(postId);
    }
  }
  
  /**
   * Deletes a comment by its id. This is a logical deletion by setting an inactive status.
   *
   * @param postId The id of the post to be deleted.
   * @param commentId The id of the post to be deleted.
   * @throws PostNotFoundException if no post is found with the given id.
   */
  @Operation(summary = "Deletes a comment by its id.")
  @DeleteMapping(path = "/delete/{postId}/{commentId}")
  public void deleteCommentById(
      @Parameter(description = "The id of the post to be deleted.")
      @PathVariable("postId") final int postId,
      @PathVariable("commentId") final int commentId
  ) {
    if (!postService.deleteCommentById(postId, commentId)) {
      throw createPostNotFoundException(postId);
    }
  }

  private PageResponseDto<PostDto> createPageResponse(final Page<Post> page) {
    return PageResponseDto.<PostDto>builder()
        .pageNumber(page.getNumber())
        .pageSize(page.getSize())
        .totalPages(page.getTotalPages())
        .results(Converter.postListToDtoList(page.getContent()))
        .build();
  }

  private PostNotFoundException createPostNotFoundException(int postId) {
    return new PostNotFoundException("Post not found with id: " + postId);
  }
}
