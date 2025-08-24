package dev.rayhan.sping_blog.article.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Article {
  private UUID id;
  private String title;
  private String handle;
  private String body;
  private boolean isPublished;
  private LocalDateTime createdAt;
}
