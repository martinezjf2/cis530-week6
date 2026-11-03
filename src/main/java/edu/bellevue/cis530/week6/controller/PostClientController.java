
package edu.bellevue.cis530.week6.controller;

import edu.bellevue.cis530.week6.dto.PostDto;
import edu.bellevue.cis530.week6.service.PostClientService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client/posts")
public class PostClientController {

    private final PostClientService postClientService;

    public PostClientController(PostClientService postClientService) {
        this.postClientService = postClientService;
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> posts = postClientService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        PostDto post = postClientService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDto>> getPostsByUserId(
            @PathVariable Long userId) {

        List<PostDto> posts = postClientService.getPostsByUserId(userId);
        return ResponseEntity.ok(posts);
    }
}
