package dev.rayhan.sping_blog.common.exceptions;

public class ResourceNotFoundException extends RuntimeException{
  public ResourceNotFoundException(String message) {
    super(message);
  }
}
