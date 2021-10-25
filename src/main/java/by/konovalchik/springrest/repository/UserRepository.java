package by.konovalchik.springrest.repository;


import by.konovalchik.springrest.entity.User;
import ch.qos.logback.core.boolex.EvaluationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


//     @Query(value="from User u where u.username = ?1")
     Optional<User> findUserByUsername(String username);

}
