package springboot.apachekafka_1.api;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.apachekafka_1.dto.KMessage;

import java.util.UUID;

@RestController
@RequestMapping("/kmessage")
@RequiredArgsConstructor
public class ResourceController {

    @Value("${tutorial.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, KMessage> kafkaTemplate;

    @PostMapping
    public void sendMessage(@RequestBody KMessage kMessage) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), kMessage);
    }
}
