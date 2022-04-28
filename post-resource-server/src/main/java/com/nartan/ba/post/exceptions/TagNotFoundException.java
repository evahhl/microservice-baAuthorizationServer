package com.nartan.ba.post.exceptions;

public class TagNotFoundException extends RuntimeException{

  public TagNotFoundException(final String message) {
    super(message);
  }
}
