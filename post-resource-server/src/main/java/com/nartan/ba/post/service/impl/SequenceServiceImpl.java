package com.nartan.ba.post.service.impl;

import com.nartan.ba.post.exceptions.CounterException;
import com.nartan.ba.post.model.entity.Counter;
import com.nartan.ba.post.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @author evahhl
 */
public class SequenceServiceImpl implements SequenceService {
  private final MongoOperations mongoOperation;

  @Autowired
  public SequenceServiceImpl(MongoOperations mongoOperation) {
    this.mongoOperation = mongoOperation;
  }

  public int getNextSequenceId(String key) {

    Query query = new Query(Criteria.where("_id").is(key));

    Update update = new Update();
    update.inc("sequence", 1);

    FindAndModifyOptions options = new FindAndModifyOptions();
    options.returnNew(true);

    Counter counter = mongoOperation.findAndModify(query, update, options, Counter.class);

    //if no id, throws SequenceException
    //optional, just a way to tell user when the sequence id is failed to generate.
    if (counter == null) {
      System.out.println("Unable to get sequence id for key : " + key);
      throw new CounterException("Unable to get sequence id for key : " + key);
    }
    return counter.getSequence();
  }
}
