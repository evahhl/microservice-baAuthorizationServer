package com.nartan.ba.post.config;

import com.nartan.ba.post.repository.PostRepository;
import com.nartan.ba.post.repository.TagRepository;
import com.nartan.ba.post.service.PostService;
import com.nartan.ba.post.service.SequenceService;
import com.nartan.ba.post.service.TagService;
import com.nartan.ba.post.service.impl.PostServiceImpl;
import com.nartan.ba.post.service.impl.SequenceServiceImpl;
import com.nartan.ba.post.service.impl.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoOperations;

//@Configuration
public class BeanConfig {

//  @Bean
//  @Autowired
//  SequenceService counterService(MongoOperations mongoOperations) {
//    return new SequenceServiceImpl(mongoOperations);
//  }
//
//  @Bean
//  @Autowired
//  public PostService postService(
//      PostRepository postRepository,
//      SequenceService sequenceGenerator,
//      MongoOperations mongoOperations
//  ) {
//    return new PostServiceImpl(postRepository, sequenceGenerator, mongoOperations);
//  }
//
//  @Bean
//  @Autowired
//  public TagService tagService(
//      TagRepository tagRepository,
//      SequenceService sequenceGenerator,
//      MongoOperations mongoOperations
//  ) {
//    return new TagServiceImpl(tagRepository, sequenceGenerator, mongoOperations);
//  }
}
