package springboot.apachekafka1.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.apachekafka1.dto.Mail;
import springboot.apachekafka1.service.ProducerService;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/message")
    public void post(@RequestBody Mail mail) {
        producerService.send(mail);
    }
}
