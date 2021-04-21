package springboot.rabbitmq.service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import springboot.rabbitmq.model.Message;

@Service
public class MessageSubscriber {

    @RabbitListener(queues = "${rabbit.queue}")
    public void handleMessage(Message message) {
        System.out.println("Message received..");
        System.out.println(message);
    }
}
