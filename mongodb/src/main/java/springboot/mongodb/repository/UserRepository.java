package springboot.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springboot.mongodb.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

    
}
