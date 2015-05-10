package by.bsuir.dashka.service.user;

import by.bsuir.dashka.entity.User;

import java.util.List;

/**
 * Created by Dashka on 03.05.2015.
 */
public interface IUserService {

    public User save(String login, String pass, String role);

    public User authUser(String login);

}
