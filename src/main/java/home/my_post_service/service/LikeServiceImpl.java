package home.my_post_service.service;

import home.my_post_service.exception.EntityNotFoundException;
import home.my_post_service.mapper.LikeMapper;
import home.my_post_service.model.dto.LikeRequestDto;
import home.my_post_service.model.dto.LikeResponseDto;
import home.my_post_service.model.entity.Like;
import home.my_post_service.model.entity.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final PostRepository postRepository;
    private final LikeMapper likeMapper;

    @Override
    public LikeResponseDto likePost(LikeRequestDto requestDto) {
        Post post = postRepository.findById(requestDto.getPostId())
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
        Like like = likeMapper.toEntity(requestDto);
        if (post.getLikes() == null) {
            post.setLikes(new ArrayList<>());
        }
        post.getLikes().add(like);

        return null;
    }
}
