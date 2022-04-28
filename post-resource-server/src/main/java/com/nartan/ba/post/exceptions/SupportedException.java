package com.nartan.ba.post.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public enum SupportedException {

  TAG_NOT_FOUND_EXCEPTION(TagNotFoundException.class, HttpStatus.NOT_FOUND),
  POST_NOT_FOUND_EXCEPTION(PostNotFoundException.class, HttpStatus.NOT_FOUND),
  USERNAME_NOT_FOUND(UsernameNotFoundException.class, HttpStatus.NOT_FOUND),
  BAD_CREDENTIALS(BadCredentialsException.class, HttpStatus.BAD_REQUEST),
  COUNTER_EXCEPTION(CounterException.class, HttpStatus.INTERNAL_SERVER_ERROR);

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
