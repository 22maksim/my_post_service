package home.my_post_service.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
    private int id;
    private String description;
    private Long authorId;
    private Long postId;
}
