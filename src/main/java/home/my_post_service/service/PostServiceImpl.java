package home.my_post_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import home.my_post_service.exception.EntityNotFoundException;
import home.my_post_service.exception.KafkaJsonException;
import home.my_post_service.mapper.PostMapper;
import home.my_post_service.model.dto.PostRequestDto;
import home.my_post_service.model.dto.PostResponseDto;
import home.my_post_service.model.entity.Post;
import home.my_post_service.model.properties.KafkaTopics;
import home.my_post_service.service.kafka.KafkaPublisherPost;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final KafkaPublisherPost kafkaPublisherPost;
    private final PostMapper postMapper;
    private final ObjectMapper objectMapper;
    private final KafkaTopics kafkaTopics;
    private final PostRepository postRepository;

    @Override
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = postMapper.toEntity(requestDto);
        //логика создания и сохранения поста
        try {
            kafkaPublisherPost.send(kafkaTopics.posts(), objectMapper.writeValueAsString(post));
        } catch (JsonProcessingException ex) {
            log.error("Don't send message create post. Error: {}", ex.getMessage());
            throw new KafkaJsonException("Don't send message create post. Error: " + ex);
        }
        return postMapper.toDto(post);
    }

    @Override
    public PostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post not found"));

        PostResponseDto postResponseDto = postMapper.toDto(post);
        try {
            kafkaPublisherPost.send(kafkaTopics.postViews(), objectMapper.writeValueAsString(postResponseDto));
        } catch (JsonProcessingException ex) {
            log.error("Don't send message view post. Error: {}", ex.getMessage());
            throw new KafkaJsonException("Don't send message view post. Error: " + ex);
        }
        return postResponseDto;
    }
}
