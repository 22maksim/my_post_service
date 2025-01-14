package home.my_post_service.service;

import home.my_post_service.model.dto.PostRequestDto;
import home.my_post_service.model.dto.PostResponseDto;
import jakarta.validation.constraints.NotNull;

public interface PostService {

    PostResponseDto createPost(PostRequestDto requestDto);

    PostResponseDto getPost(@NotNull Long id);
}
