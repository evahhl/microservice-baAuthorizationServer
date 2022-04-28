package com.nartan.ba.post.repository;

import com.nartan.ba.post.model.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends MongoRepository<Tag, Integer> {
  Page<Tag> findByStatusEquals(int status, Pageable pageable);
}
