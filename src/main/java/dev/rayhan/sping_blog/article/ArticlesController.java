package dev.rayhan.sping_blog.article;


import dev.rayhan.sping_blog.article.dtos.CreateArticlePayload;
import dev.rayhan.sping_blog.article.entities.Article;
import dev.rayhan.sping_blog.common.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/articles")
public class ArticlesController {
  List<Article> articles = new ArrayList<>(List.of(
    Article.builder()
      .id(UUID.randomUUID())
      .title("article 1")
      .body("article 1 body")
      .isPublished(true)
      .build(),
    Article.builder()
      .id(UUID.randomUUID())
      .title("article 2")
      .body("article 2 body")
      .isPublished(true)
      .build(),
    Article.builder()
      .id(UUID.randomUUID())
      .title("article 3")
      .body("article 3 body")
      .isPublished(false)
      .build()
  ));


  @GetMapping
  public ResponseEntity<List<Article>> getArticles(

  ) {
//
//     articles =  articles
//       .stream()
//       .filter(article -> article.isPublished())
//       .toList();


    return ResponseEntity.ok(articles);
  }

  @GetMapping("{id}")
  public ResponseEntity<?> getArticle(
    @PathVariable UUID id
  ) {
    var article = articles.stream()
      .filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Article not found"));

    return ResponseEntity.ok(article);
  }


  @PostMapping
  public ResponseEntity<?> createArticle(
    @Valid @RequestBody CreateArticlePayload payload,
    UriComponentsBuilder uriBuilder
  ) {
    var article = Article.builder()
      .id(UUID.randomUUID())
      .title(payload.getTitle())
      .body(payload.getBody())
      .isPublished(payload.isPublished())
      .createdAt(LocalDateTime.now())
      .build();

    articles.add(article);

    var uri = uriBuilder.path("/api/articles/{id}").buildAndExpand(article.getId()).toUri();

    return ResponseEntity.created(uri).build();
  }


  @DeleteMapping("{id}")
  public ResponseEntity<?> createArticle(
    @PathVariable UUID id
  ) {

    var article = articles.stream().filter(a -> a.getId().equals(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("Article not found"));
    articles.remove(article);
    return ResponseEntity.noContent().build();
  }
}
