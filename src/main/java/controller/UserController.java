package controller;

import Model.KafkaProducer;
import Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final KafkaProducer producer;


    @PostMapping("/users")
    public void sendMessageToKafkaTopic(@RequestBody User user) {
        this.producer.sendMessage(user);
    }
}

