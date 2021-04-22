package springboot.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.mongodb.entity.User;
import springboot.mongodb.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.insert(user);
    }

    public User getUserById(Integer id) {
        return repository.findById(id).get();
    }

    public List<User> getUsers() {
        return repository.findAll();
    }
}
