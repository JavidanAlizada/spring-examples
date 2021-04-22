package springboot.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
    @Id
    private int id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime registeredAt;
    private boolean isActive;
    private float weight;
    private float height;
    private List<Hobby> hobbies;
    private Map<String, Integer> workPositionAndSalary;
}
