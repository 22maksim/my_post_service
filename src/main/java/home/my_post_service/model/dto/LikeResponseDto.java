package home.my_post_service.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeResponseDto {
    private Long id;
    private Long postId;
    private Long likedUserId;
}
