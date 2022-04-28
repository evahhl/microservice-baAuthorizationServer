package com.nartan.ba.post.service.impl;

import com.nartan.ba.post.model.entity.Tag;
import com.nartan.ba.post.repository.TagRepository;
import com.nartan.ba.post.service.SequenceService;
import com.nartan.ba.post.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Optional;

import static com.nartan.ba.post.util.Constants.ACTIVE;
import static com.nartan.ba.post.util.Constants.INACTIVE;

public class TagServiceImpl implements TagService {

  private final TagRepository repository;
  private final SequenceService sequenceGenerator;
  private final MongoOperations mongoOperation;

  @Autowired
  public TagServiceImpl(
      final TagRepository repository,
      final SequenceService sequenceGenerator,
      final MongoOperations mongoOperation
  ) {
    this.repository = repository;
    this.sequenceGenerator = sequenceGenerator;
    this.mongoOperation = mongoOperation;
  }

  @Override
  public Tag add(final Tag tag) {
    tag.setId(sequenceGenerator.getNextSequenceId(Tag.SEQUENCE_NAME));
    return repository.save(tag);
  }

  @Override
  public Page<Tag> getAll(final Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public Page<Tag> getAllActive(Pageable pageable) {
    return repository.findByStatusEquals(ACTIVE, pageable);
  }

  @Override
  public Page<Tag> getAllInactive(Pageable pageable) {
    return repository.findByStatusEquals(INACTIVE, pageable);
  }

  @Override
  public Optional<Tag> getById(final int id) {
    return repository.findById(id);
  }

  @Override
  public void deleteById(final int id) {
    getById(id).ifPresent(tag -> {
      Query query = new Query(Criteria.where("_id").is(id));
      Update update = new Update().set("status", INACTIVE);
      mongoOperation.findAndModify(query, update, Tag.class);
    });
    repository.deleteById(id);
  }
}
