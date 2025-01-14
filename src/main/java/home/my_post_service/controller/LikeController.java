package home.my_post_service.controller;

import home.my_post_service.model.dto.LikeRequestDto;
import home.my_post_service.model.dto.LikeResponseDto;
import home.my_post_service.service.LikeService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("api/v1/like")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping
    public LikeResponseDto addLike(@RequestBody @NotNull LikeRequestDto likeRequestDto) {
        return likeService.likePost(likeRequestDto);
    }
}
