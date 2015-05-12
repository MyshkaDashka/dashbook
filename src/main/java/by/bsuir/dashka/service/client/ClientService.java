package by.bsuir.dashka.service.client;

import by.bsuir.dashka.entity.Client;
import by.bsuir.dashka.entity.Client_FriendList;
import by.bsuir.dashka.entity.User;
import by.bsuir.dashka.repository.ClientFriendRepository;
import by.bsuir.dashka.repository.ClientRepository;
import by.bsuir.dashka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dashka on 26.04.2015.
 */
@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientFriendRepository clientFriendRepository;

    @Transactional
    public Client findClient(Integer id) {
        Client client = clientRepository.findOne(id);
        return client;
    }

    @Transactional
    public Set<Client> getFriends(Integer id) {
        List<Client_FriendList> client_friendLists = clientFriendRepository.findByIdClient(id);
        Set<Client> friends = new HashSet<Client>();
        for (Client_FriendList cf : client_friendLists) {
            friends.add(clientRepository.findOne(cf.getIdFriend()));
        }
        return friends;
    }

    @Transactional
    public Client save(String name, String lastName, User user) {
        Client client = new Client();
        client.setName(name);
        client.setLastName(lastName);
        client.setUser(user);
        return clientRepository.save(client);
    }

    @Transactional
    public Client update(Integer id, String city, String birthday, String phone, String study, String work, String about) {
        Client client = clientRepository.findOne(id);
        client.setCity(city);
        client.setBirthday(birthday);
        client.setPhone(phone);
        client.setStudy(study);
        client.setWork(work);
        client.setAboutMe(about);
        return clientRepository.save(client);
    }

    @Transactional
    public void addFriend(Integer clientId, Integer friendId) {
        Client_FriendList cf = new Client_FriendList();
        cf.setIdClient(clientId);
        cf.setIdFriend(friendId);
        clientFriendRepository.save(cf);
    }

    @Transactional
    public Boolean checkFriendAdd(Integer idClient, Integer idFriend) {
        if (clientFriendRepository.findByIdClientAndIdFriend(idClient, idFriend) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Transactional
    public void removeFriend(Integer clientId, Integer friendId) {
        Client_FriendList cf = clientFriendRepository.findByIdClientAndIdFriend(clientId, friendId);
        clientFriendRepository.delete(cf);
    }
}
