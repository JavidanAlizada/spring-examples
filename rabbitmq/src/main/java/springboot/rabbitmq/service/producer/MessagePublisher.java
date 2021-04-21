package springboot.rabbitmq.service.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import springboot.rabbitmq.model.Message;

@Service
public class MessagePublisher {

    @Value("${rabbit.routing}")
    private String routingName;

    @Value("${rabbit.exchange}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(Message message) {
        System.out.println("Notification Sent ID : " + message.getMessageBody());
        rabbitTemplate.convertAndSend(exchangeName, routingName, message);
    }
}
