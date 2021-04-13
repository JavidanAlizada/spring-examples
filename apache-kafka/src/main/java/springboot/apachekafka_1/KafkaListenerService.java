package springboot.apachekafka_1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import springboot.apachekafka_1.dto.KMessage;

@Slf4j
@Service
public class KafkaListenerService {

    @KafkaListener(
            topics = "${tutorial.kafka.topic}",
            groupId = "${tutorial.kafka.group.id}"
    )
    public void listen(@Payload KMessage message) {
        log.info("Message received.. MessageID : {} Message: {} Date : {}",
                message.getId(),
                message.getMessage(),
                message.getMessageDate());
    }
}
