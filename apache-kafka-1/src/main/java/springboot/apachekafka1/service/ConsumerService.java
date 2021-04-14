package springboot.apachekafka1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import springboot.apachekafka1.dto.Mail;

@Service
@Slf4j
public class ConsumerService {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.topic.group_id}")
    public void consume(@Payload  Mail mail) {
        log.info("Consumed Mail: " + mail);
    }
}
