package home.my_post_service.service;

import home.my_post_service.model.dto.LikeRequestDto;
import home.my_post_service.model.dto.LikeResponseDto;

public interface LikeService {

    LikeResponseDto likePost(LikeRequestDto requestDto);

}
