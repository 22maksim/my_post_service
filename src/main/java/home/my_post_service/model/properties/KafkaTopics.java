package home.my_post_service.model.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("topic.kafka")
public record KafkaTopics(
        String likes,
        String posts,
        String  postViews,
        String comments
) {
}
