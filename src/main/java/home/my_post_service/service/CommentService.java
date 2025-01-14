package home.my_post_service.service;

import home.my_post_service.model.dto.CommentRequestDto;
import home.my_post_service.model.dto.CommentResponseDto;

public interface CommentService {
    CommentResponseDto addCommentForPost(CommentRequestDto commentRequestDto);
}
