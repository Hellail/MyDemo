package Model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducer {


    @Value("${topic.name}")
    private String topic;

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        this.kafkaTemplate.send(this.topic, user);
        log.info(String.format("Produced user -> %s", user));
    }
}