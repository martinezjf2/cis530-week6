
package edu.bellevue.cis530.week6.service;

import edu.bellevue.cis530.week6.dto.PostDto;
import java.util.List;

public interface PostClientService {

    List<PostDto> getAllPosts();

    PostDto getPostById(Long id);

    List<PostDto> getPostsByUserId(Long userId);
}
