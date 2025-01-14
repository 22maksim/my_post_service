package home.my_post_service.mapper;

import home.my_post_service.model.dto.PostRequestDto;
import home.my_post_service.model.dto.PostResponseDto;
import home.my_post_service.model.entity.Comment;
import home.my_post_service.model.entity.Like;
import home.my_post_service.model.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    @Mapping(source = "comments", target = "commentIds", qualifiedByName = "extractCommentIds")
    @Mapping(source = "likes", target = "likeIds", qualifiedByName = "extractLikeIds")
    PostResponseDto toDto(Post post);

    Post toEntity(PostRequestDto postRequestDto);

    // Методы для извлечения идентификаторов из связанных сущностей

    @Named("extractCommentIds")
    default List<Long> extractCommentIds(List<Comment> comments) {
        if (comments == null || comments.isEmpty()) {
            return List.of();
        }
        return comments.stream()
                .map(Comment::getId)
                .toList();
    }

    @Named("extractLikeIds")
    default List<Long> extractLikeIds(List<Like> likes) {
        if (likes == null || likes.isEmpty()) {
            return List.of();
        }
        return likes.stream()
                .map(Like::getId)
                .toList();
    }
}
