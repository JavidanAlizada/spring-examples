package springboot.apachekafka_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.apachekafka_2.dto.Message;
import springboot.apachekafka_2.service.KafkaMessagePublisher;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

    @Autowired
    static KafkaMessagePublisher kafkaMessagePublisher;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Message message = new Message();
        message.setMessageFrom("Javidan");
        message.setMessageTo("Sahib");
        message.setMessageBody("Hello How are you");
        message.setMessageDate(LocalDate.now());
        kafkaMessagePublisher.sendMessage(message);
    }

}
