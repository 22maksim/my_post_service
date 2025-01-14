package home.my_post_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    private long id;

    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
