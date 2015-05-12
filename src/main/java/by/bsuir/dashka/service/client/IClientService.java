package by.bsuir.dashka.service.client;

import by.bsuir.dashka.entity.Client;
import by.bsuir.dashka.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Dashka on 26.04.2015.
 */
public interface IClientService {

    public Client findClient(Integer id);

    public Set<Client> getFriends(Integer id);

    public Client save(String name, String lastName, User user);

    public void addFriend(Integer clientId, Integer friendId);

    public Client update(Integer id, String city, String birthday, String phone, String study, String work, String about);

    public Boolean checkFriendAdd (Integer idClient, Integer idFriend);
}
