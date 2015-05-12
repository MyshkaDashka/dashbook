package by.bsuir.dashka.entity;

import javax.persistence.*;

/**
 * Created by Dashka on 12.05.2015.
 */
@Entity
public class Client_FriendList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer idClient;

    @Column(nullable = false)
    private Integer idFriend;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdFriend() {
        return idFriend;
    }

    public void setIdFriend(Integer idFriend) {
        this.idFriend = idFriend;
    }
}
