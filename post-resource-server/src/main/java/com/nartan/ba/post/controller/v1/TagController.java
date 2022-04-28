package com.nartan.ba.post.controller.v1;

import com.nartan.ba.post.exceptions.TagNotFoundException;
import com.nartan.ba.post.model.dto.PageResponseDto;
import com.nartan.ba.post.model.dto.TagDto;
import com.nartan.ba.post.model.entity.Tag;
import com.nartan.ba.post.service.TagService;
import com.nartan.ba.post.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.nartan.ba.post.util.Constants.*;

@RestController
@RequestMapping(value = "/v1/tag", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TagController {

  private final TagService tagService;

  @Autowired
  public TagController(final TagService tagService) {
    this.tagService = tagService;
  }

  @GetMapping("/all")
  public PageResponseDto<TagDto> getAll(
      @RequestParam(defaultValue = FIRST_PAGE) final int page,
      @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) final int size,
      @RequestParam(defaultValue = SORT_BY_ID) final String sortBy
  ) {
    return createPageResponse(tagService.getAll(PageRequest.of(page, size, Sort.by(sortBy))));
  }

  @GetMapping("/all/active")
  public PageResponseDto<TagDto> getAllActive(
      @RequestParam(defaultValue = FIRST_PAGE) final int page,
      @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) final int size,
      @RequestParam(defaultValue = SORT_BY_ID) final String sortBy
  ) {
    return createPageResponse(tagService.getAllActive(PageRequest.of(page, size, Sort.by(sortBy))));
  }

  @GetMapping("/all/inactive")
  public PageResponseDto<TagDto> getAllInactive(
      @RequestParam(defaultValue = FIRST_PAGE) final int page,
      @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) final int size,
      @RequestParam(defaultValue = SORT_BY_ID) final String sortBy
  ) {
    return createPageResponse(
        tagService.getAllInactive(PageRequest.of(page, size, Sort.by(sortBy))));
  }

  @PostMapping("/add")
  public TagDto add(@RequestBody final Tag tag) {
    return Converter.toTagDtoFrom(tagService.add(tag));
  }

  @GetMapping("/{tagId}")
  public TagDto getById(@PathVariable("tagId") final int tagId) {
    return Converter.toTagDtoFrom(tagService.getById(tagId)
        .orElseThrow(() -> new TagNotFoundException("Tag not found")));
  }

  @DeleteMapping("/delete/{tagId}")
  public void deleteById(@PathVariable("tagId") final int tagId) {
    tagService.deleteById(getById(tagId).id());
  }

  private PageResponseDto<TagDto> createPageResponse(final Page<Tag> page) {
    return PageResponseDto.<TagDto>builder()
        .pageNumber(page.getNumber())
        .pageSize(page.getSize())
        .totalPages(page.getTotalPages())
        .results(Converter.toTagDtoListFrom(page.getContent()))
        .build();
  }
}
