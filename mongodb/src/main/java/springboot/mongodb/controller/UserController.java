package springboot.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.mongodb.entity.Hobby;
import springboot.mongodb.entity.Position;
import springboot.mongodb.entity.User;
import springboot.mongodb.service.UserService;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        List<Hobby> hobbies = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            Hobby hobby = new Hobby();
            hobby.setName("hobby" + i);
            hobby.setDescription("description" + i);
            hobbies.add(hobby);
            map.put("hobby"+i, i);
        }
        User user = new User();
        user.setId(5);
        user.setUsername("Javidan");
        user.setEmail("javidan@gmail.com");
        user.setPassword("Javidan123");
        user.setActive(false);
        user.setHeight(1.84f);
        user.setWeight(77.87f);
        user.setRegisteredAt(LocalDateTime.now());
        user.setWorkPositionAndSalary(map);
        user.setHobbies(hobbies);
        userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }


    @PostMapping
    public ResponseEntity<User> post(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getUsers());
    }
}
