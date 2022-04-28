package com.nartan.ba.post.service;

/**
 * @author evahhl
 */
public interface SequenceService {

  /**
   * @param sequenceName
   * @return
   */
  int getNextSequenceId(String sequenceName);
}
