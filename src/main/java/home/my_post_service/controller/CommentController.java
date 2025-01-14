package home.my_post_service.controller;

import home.my_post_service.model.dto.CommentRequestDto;
import home.my_post_service.model.dto.CommentResponseDto;
import home.my_post_service.service.CommentService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public CommentResponseDto addCommentForPost(@RequestBody @NotNull CommentRequestDto commentRequestDto) {
        return commentService.addCommentForPost(commentRequestDto);
    }
}
