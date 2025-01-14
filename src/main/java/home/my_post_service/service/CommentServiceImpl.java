package home.my_post_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import home.my_post_service.exception.KafkaJsonException;
import home.my_post_service.mapper.CommentMapper;
import home.my_post_service.model.dto.CommentRequestDto;
import home.my_post_service.model.dto.CommentResponseDto;
import home.my_post_service.model.entity.Comment;
import home.my_post_service.model.properties.KafkaTopics;
import home.my_post_service.service.kafka.KafkaPublisherPost;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;
    private final ObjectMapper objectMapper;
    private final KafkaPublisherPost kafkaPublisherPost;
    private final KafkaTopics kafkaTopics;

    @Override
    public CommentResponseDto addCommentForPost(CommentRequestDto commentRequestDto) {
        Comment comment = commentMapper.toEntity(commentRequestDto);
        //Логика обработки добавления сохранения комментария
        CommentResponseDto responseDto = commentMapper.toDto(comment);
        try {
            kafkaPublisherPost.send(kafkaTopics.comments(), objectMapper.writeValueAsString(responseDto));
        } catch (JsonProcessingException e) {
            log.error("Comment json processing error: {}", e.getMessage());
            throw new KafkaJsonException("Comment json processing error: " + e.getMessage());
        }
        return responseDto;
    }
}
