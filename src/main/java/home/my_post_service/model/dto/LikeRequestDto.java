package home.my_post_service.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeRequestDto {
    private Long postId;
    private Long likedUserId;
}
