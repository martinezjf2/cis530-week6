
package edu.bellevue.cis530.week6.client;

import edu.bellevue.cis530.week6.dto.PostDto;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Component
public class JsonPlaceholderClient {

    private final WebClient webClient;

    public JsonPlaceholderClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<PostDto> getAllPosts() {
        List<PostDto> posts = webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(PostDto.class)
                .collectList()
                .block();

        return posts != null ? posts : Collections.emptyList();
    }

    public PostDto getPostById(Long id) {
        return webClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .bodyToMono(PostDto.class)
                .block();
    }

    public List<PostDto> getPostsByUserId(Long userId) {
        List<PostDto> posts = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/posts")
                        .queryParam("userId", userId)
                        .build())
                .retrieve()
                .bodyToFlux(PostDto.class)
                .collectList()
                .block();

        return posts != null ? posts : Collections.emptyList();
    }
}
