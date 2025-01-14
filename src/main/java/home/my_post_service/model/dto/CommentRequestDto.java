package home.my_post_service.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDto {
    private String comment;
    private Long authorId;
    private Long postId;
}
