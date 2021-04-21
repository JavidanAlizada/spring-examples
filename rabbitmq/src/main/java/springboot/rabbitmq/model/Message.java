package springboot.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

//    @JsonIgnore
    private String id = UUID.randomUUID().toString();
    private String messageBody;
//    @JsonIgnore
    private LocalDateTime dateTime = LocalDateTime.now();
}
