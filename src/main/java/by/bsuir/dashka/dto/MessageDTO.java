package by.bsuir.dashka.dto;

import by.bsuir.dashka.entity.Client;
import by.bsuir.dashka.entity.Message;
import lombok.Data;

/**
 * Created by Dashka on 09.05.2015.
 */
@Data
public class MessageDTO {
    private  String nameFriend;

    private String lastNameFriend;

    private Message message;

    public MessageDTO(String nameFriend, String lastNameFriend, Message message){
        this.nameFriend = nameFriend;
        this.lastNameFriend = lastNameFriend;
        this.message = message;
    }
}
