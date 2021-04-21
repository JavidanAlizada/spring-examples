package springboot.rabbitmq.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.rabbitmq.model.Message;
import springboot.rabbitmq.service.producer.MessagePublisher;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessagePublisher publisher;

    @PostMapping
    public void post(@RequestBody Message message) {
        System.out.println(message);
        publisher.sendToQueue(message);
    }
}
