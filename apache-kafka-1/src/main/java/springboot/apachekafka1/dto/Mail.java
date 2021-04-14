package springboot.apachekafka1.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mail implements Serializable {

    private String id = UUID.randomUUID().toString();
    private String messageFrom;
    private String messageTo;
    private String messageBody;
    private LocalDateTime dateTime = LocalDateTime.now();
}
