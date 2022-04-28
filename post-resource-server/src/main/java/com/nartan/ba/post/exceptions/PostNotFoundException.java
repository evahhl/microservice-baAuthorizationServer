package com.nartan.ba.post.exceptions;

public class PostNotFoundException extends RuntimeException {

  public PostNotFoundException(final String message) {
    super(message);
  }
}
