package home.my_post_service.mapper;

import home.my_post_service.model.dto.CommentRequestDto;
import home.my_post_service.model.dto.CommentResponseDto;
import home.my_post_service.model.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    Comment toEntity(CommentRequestDto commentRequestDto);

    CommentResponseDto toDto(Comment comment);
}
