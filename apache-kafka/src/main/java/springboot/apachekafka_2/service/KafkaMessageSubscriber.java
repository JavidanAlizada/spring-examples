package springboot.apachekafka_2.service;

import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@PropertySource("classpath:kafka.yml")
@Service
public class KafkaMessageSubscriber {

    @KafkaListener(topics = "${tutorial1.kafka.topic.name}", groupId = "${tutorial1.kafka.topic.group_id}")
    public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("Received Message: " + message + " from partition: " + partition);
    }
}
