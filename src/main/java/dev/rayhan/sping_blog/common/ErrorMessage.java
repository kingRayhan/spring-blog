package dev.rayhan.sping_blog.common;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ErrorMessage {
  private String message;
  private Map<String, String> errors;
}
