
package edu.bellevue.cis530.week6.service.impl;

import edu.bellevue.cis530.week6.client.JsonPlaceholderClient;
import edu.bellevue.cis530.week6.dto.PostDto;
import edu.bellevue.cis530.week6.service.PostClientService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostClientServiceImpl implements PostClientService {

    private final JsonPlaceholderClient jsonPlaceholderClient;

    public PostClientServiceImpl(
            JsonPlaceholderClient jsonPlaceholderClient) {
        this.jsonPlaceholderClient = jsonPlaceholderClient;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return jsonPlaceholderClient.getAllPosts();
    }

    @Override
    public PostDto getPostById(Long id) {
        return jsonPlaceholderClient.getPostById(id);
    }

    @Override
    public List<PostDto> getPostsByUserId(Long userId) {
        return jsonPlaceholderClient.getPostsByUserId(userId);
    }
}
