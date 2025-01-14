package home.my_post_service.mapper;

import home.my_post_service.model.dto.LikeRequestDto;
import home.my_post_service.model.dto.LikeResponseDto;
import home.my_post_service.model.entity.Like;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LikeMapper {

    LikeResponseDto toDto(Like like);

    Like toEntity(LikeRequestDto likeRequestDto);

}
