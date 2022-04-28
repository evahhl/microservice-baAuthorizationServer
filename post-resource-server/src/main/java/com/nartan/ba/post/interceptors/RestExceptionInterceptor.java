package com.nartan.ba.post.interceptors;

import com.nartan.ba.post.exceptions.SupportedException;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionInterceptor {

  private final Logger logger = LoggerFactory.getLogger(RestExceptionInterceptor.class);

  @ExceptionHandler
  public ResponseEntity<Map<Object, Object>> processSupportedExceptions(final Throwable throwable) {
    final Optional<ResponseEntity<Map<Object, Object>>> supportedException =
        Arrays.stream(SupportedException.values())
            .filter(supportedEx -> hasSameClass(supportedEx, throwable))
            .map(supportedEx -> createResponseEntityFromException(supportedEx, throwable))
            .findFirst();

    logger.debug("Exception: ", throwable);

    // return the matching supportedException if present,
    // if not, respond with INTERNAL_SERVER_ERROR
    return supportedException
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
  }

  private boolean hasSameClass(
      final SupportedException supportedException,
      final Throwable throwable
  ) {
    return throwable.getClass().equals(supportedException.getExceptionClass());
  }

  private ResponseEntity<Map<Object, Object>> createResponseEntityFromException(
      final SupportedException supportedException,
      final Throwable throwable
  ) {
    Objects.requireNonNull(supportedException);

    return new ResponseEntity<>(ImmutableMap.builder()
        .put("status", supportedException.getStatus().value())
        .put("error", supportedException.getStatus().getReasonPhrase())
        .put("message", throwable.getMessage())
        .build(),
        supportedException.getStatus());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<Object, Object>> validationException(
      MethodArgumentNotValidException ex
  ) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors()
        .forEach(error -> {
          String fieldName = ((FieldError) error).getField();
          String errorMessage = error.getDefaultMessage();
          errors.put(fieldName, errorMessage);
        });

    return new ResponseEntity<>(ImmutableMap.builder()
        .put("status", HttpStatus.BAD_REQUEST.value())
        .put("error", "Validation failed for given request.")
        .put("message", errors)
        .build(),
        HttpStatus.BAD_REQUEST);
  }
}
