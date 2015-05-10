package by.bsuir.dashka.repository;

import by.bsuir.dashka.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dashka on 25.04.2015.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByLogin(String login);

}
