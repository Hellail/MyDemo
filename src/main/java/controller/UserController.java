package controller;

import com.example.MyDemo.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserController {

    private final KafkaProducer producer;


    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        this.producer.sendMessage(new User(name, age));
    }
}

