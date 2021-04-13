package springboot.apachekafka_2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "messageFrom", "messageTo", "messageBody",  "messageDate"})
public class Message {

    private String messageFrom;
    private String messageTo;
    private String messageBody;
    private String id = UUID.randomUUID().toString();
    private LocalDate messageDate = LocalDate.now();
}
