package dev.rayhan.sping_blog.article.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateArticlePayload {
  @NotBlank(message = "Title is required")
  @Size(min = 5, max = 255, message = "Title must be between 5 and 255 characters")
  private String title;
  private String body;
  private boolean isPublished;
}
