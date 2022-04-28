package com.nartan.ba.post.repository;

import com.nartan.ba.post.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author evahhl
 *
 */
@Repository
public interface PostRepository extends MongoRepository<Post, Integer> {

  Page<Post> findByStatusEquals(int status, Pageable pageable);

  Optional<Post> findByIdAndStatusEquals(int id, int status);
}
