package by.bsuir.dashka.service.message;

import by.bsuir.dashka.dto.MessageDTO;
import by.bsuir.dashka.entity.Message;

import java.util.List;

/**
 * Created by Dashka on 04.05.2015.
 */
public interface IMessageService {

    public Message save(Integer to, Integer from, String title, String text);

    public List<MessageDTO> getSentMessageDTOList(Integer idClient);

    public List<MessageDTO> geMessageDTOList(Integer idClient, Boolean status);
}
