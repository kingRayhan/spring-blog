package dev.rayhan.sping_blog;

import dev.rayhan.sping_blog.article.entities.Article;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class SpingBlogApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpingBlogApplication.class, args);
  }
}
