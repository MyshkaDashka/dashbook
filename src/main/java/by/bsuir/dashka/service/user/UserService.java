package by.bsuir.dashka.service.user;

import by.bsuir.dashka.entity.User;
import by.bsuir.dashka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Dashka on 03.05.2015.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(String login, String pass, String role) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(pass);
        user.setRole(role);
        return userRepository.save(user);
    }


    @Transactional
    public User authUser(String login) {
        return userRepository.findByLogin(login);
    }


}
