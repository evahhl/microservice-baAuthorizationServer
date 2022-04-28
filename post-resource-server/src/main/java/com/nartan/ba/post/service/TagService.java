package com.nartan.ba.post.service;

import com.nartan.ba.post.model.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TagService {

  Tag add(Tag tag);

  Page<Tag> getAll(Pageable pageable);

  Page<Tag> getAllActive(Pageable pageable);

  Page<Tag> getAllInactive(Pageable pageable);

  Optional<Tag> getById(int id);

  void deleteById(int id);
}
