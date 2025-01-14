package home.my_post_service.exception;

public class KafkaJsonException extends RuntimeException {
    public KafkaJsonException(String message) {
        super(message);
    }
}
