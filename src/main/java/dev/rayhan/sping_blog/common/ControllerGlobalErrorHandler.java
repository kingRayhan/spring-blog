package dev.rayhan.sping_blog.common;

import dev.rayhan.sping_blog.common.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerGlobalErrorHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorMessage> handleArticleNotFoundException(
    ResourceNotFoundException ex
  ) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
      .body(ErrorMessage.builder()
        .message(ex.getMessage())
        .build());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleArticleNotFoundException(
    BindingResult bindingResult
  ) {
      Map<String, String> errors = new HashMap<>();
      bindingResult.getFieldErrors().forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));
      return ResponseEntity.badRequest().body(errors);
  }
}
