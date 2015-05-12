package by.bsuir.dashka.repository;

import by.bsuir.dashka.entity.Client_FriendList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dashka on 12.05.2015.
 */
public interface ClientFriendRepository extends JpaRepository<Client_FriendList, Integer> {

    public List<Client_FriendList> findByIdClient(Integer idClient);

    public Client_FriendList findByIdClientAndIdFriend(Integer idClient, Integer idFriend);
}
