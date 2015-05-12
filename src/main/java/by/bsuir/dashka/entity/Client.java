package by.bsuir.dashka.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Dashka on 26.04.2015.
 */
@Entity

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private String birthday;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = true)
    private String city;

    @Column(nullable = true)
    private String photo;

    @Column(nullable = true)
    private String work;

    @Column(nullable = true)
    private String study;

    @Column(nullable = true, columnDefinition="TEXT")
    private  String aboutMe;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "client_friend",
            joinColumns = {@JoinColumn(name = "client_id")},
            inverseJoinColumns = {@JoinColumn(name = "friend_id")})
    private Set<Client> friends = new HashSet<Client>();

    @ManyToMany(mappedBy = "friends", fetch = FetchType.LAZY)
    private Set<Client> clients = new HashSet<Client>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getStudy() {
        return study;
    }

    public void setStudy(String study) {
        this.study = study;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Client> getFriends() {
        return friends;
    }

    public void setFriends(Set<Client> friends) {
        this.friends = friends;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        if (!id.equals(client.id)) return false;
        if (!name.equals(client.name)) return false;
        if (!lastName.equals(client.lastName)) return false;
        if (birthday != null ? !birthday.equals(client.birthday) : client.birthday != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        if (city != null ? !city.equals(client.city) : client.city != null) return false;
        if (photo != null ? !photo.equals(client.photo) : client.photo != null) return false;
        if (work != null ? !work.equals(client.work) : client.work != null) return false;
        if (study != null ? !study.equals(client.study) : client.study != null) return false;
        return !(aboutMe != null ? !aboutMe.equals(client.aboutMe) : client.aboutMe != null);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (work != null ? work.hashCode() : 0);
        result = 31 * result + (study != null ? study.hashCode() : 0);
        result = 31 * result + (aboutMe != null ? aboutMe.hashCode() : 0);
        return result;
    }
}
