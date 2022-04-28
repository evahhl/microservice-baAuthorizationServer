package com.nartan.ba.resource.exception;

public class PostNotFoundException extends RuntimeException {

  public PostNotFoundException(final String message) {
    super(message);
  }
}
