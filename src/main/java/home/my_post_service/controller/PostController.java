package home.my_post_service.controller;

import home.my_post_service.model.dto.PostRequestDto;
import home.my_post_service.model.dto.PostResponseDto;
import home.my_post_service.service.PostService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postServiceImpl;

    @PostMapping
    public PostResponseDto createPost(@RequestBody @NotNull PostRequestDto postRequestDto) {
        return postServiceImpl.createPost(postRequestDto);
    }

    @GetMapping("{id}")
    public PostResponseDto getPost(@PathVariable @NotNull Long id) {
        return postServiceImpl.getPost(id);
    }
}
