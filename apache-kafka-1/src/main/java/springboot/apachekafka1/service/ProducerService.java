package springboot.apachekafka1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import springboot.apachekafka1.dto.Mail;

import java.util.UUID;

@Service
@Slf4j
public class ProducerService {

    @Value("${kafka.topic.name}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Mail> kafkaTemplate;

    public void send(Mail mail) {
        ListenableFuture<SendResult<String, Mail>> future = this.kafkaTemplate.send(topic, UUID.randomUUID().toString()
                , mail);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Mail>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=[ {} ] due to : {}", mail, ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Mail> result) {
                log.info("Sent message=[ {} ] with offset=[ {} ]", mail, result.getRecordMetadata().offset());
            }
        });
    }

}
