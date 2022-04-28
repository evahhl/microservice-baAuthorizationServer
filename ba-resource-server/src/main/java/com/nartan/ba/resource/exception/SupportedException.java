package com.nartan.ba.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;

public enum SupportedException {

  POST_NOT_FOUND_EXCEPTION(PostNotFoundException.class, HttpStatus.NOT_FOUND),
  BAD_CREDENTIALS(BadCredentialsException.class, HttpStatus.BAD_REQUEST);

  private Class<? extends Throwable> exceptionClass;
  private HttpStatus status;

  SupportedException(
      final Class<? extends Throwable> exceptionClass,
      final HttpStatus status
  ) {
    this.exceptionClass = exceptionClass;
    this.status = status;
  }

  public Class<? extends Throwable> getExceptionClass() {
    return exceptionClass;
  }

  public HttpStatus getStatus() {
    return status;
  }
}
