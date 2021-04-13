package springboot.apachekafka_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import springboot.apachekafka_2.dto.Message;

import java.util.UUID;

@PropertySource("classpath:kafka.yml")
public class KafkaMessagePublisher {

    @Value("${tutorial1.kafka.topic.name}")
    private String topicName;

    private String key = UUID.randomUUID().toString();

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public void sendMessage(Message msg) {
        ListenableFuture<SendResult<String, Message>> future =
                kafkaTemplate.send(topicName, msg);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {

            @Override
            public void onSuccess(SendResult<String, Message> result) {
                System.out.println("Sent message=[" + msg +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + msg.toString() + "] due to : " + ex.getMessage());
            }
        });
    }
}
