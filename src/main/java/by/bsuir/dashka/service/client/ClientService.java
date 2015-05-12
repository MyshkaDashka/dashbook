package by.bsuir.dashka.service.client;

import by.bsuir.dashka.entity.Client;
import by.bsuir.dashka.entity.User;
import by.bsuir.dashka.repository.ClientRepository;
import by.bsuir.dashka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Dashka on 26.04.2015.
 */
@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client findClient(Integer id) {
        Client client = clientRepository.findOne(id);
        return client;
    }

    @Transactional
    public Set<Client> getFriends(Integer id) {
        Client client = clientRepository.findOne(id);
        Set<Client> friends = client.getFriends();
        Set<Client> clients = client.getClients();
        for (Client c : friends) {
            c.setFriends(null);
            c.setClients(null);
        }
        for (Client c : clients) {
            c.setFriends(null);
            c.setClients(null);
        }
        friends.addAll(clients);
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
    public Client update(Integer id, String city, String birthday, String phone, String study, String work, String about){
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
        Client client = clientRepository.findOne(clientId);
        Client friend = clientRepository.findOne(friendId);
        client.getFriends().add(friend);
        clientRepository.save(client);
        friend.getFriends().add(client);
        clientRepository.save(friend);
    }

    @Transactional
    public Boolean checkFriendAdd (Integer idClient, Integer idFriend){
        return clientRepository.findOne(idClient).getFriends().contains(clientRepository.findOne(idFriend));
    }
}
