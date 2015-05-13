package by.bsuir.dashka.service.message;

import by.bsuir.dashka.dto.MessageDTO;
import by.bsuir.dashka.entity.Client;
import by.bsuir.dashka.entity.Message;
import by.bsuir.dashka.repository.ClientRepository;
import by.bsuir.dashka.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dashka on 04.05.2015.
 */
@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ClientRepository clientRepository;


    @Transactional
    public Message save(Integer to, Integer from, String title, String text, Boolean status) {
        Message message = new Message();
        message.setIdTo(to);
        message.setIdFrom(from);
        message.setTitle(title);
        message.setText(text);
        long curTime = System.currentTimeMillis();
        Date curDate = new Date(curTime);
        message.setDate(curDate);
        message.setStatus(status);
        return messageRepository.save(message);
    }

    @Transactional
    public Message update(Integer idMess) {
        Message message = messageRepository.findOne(idMess);
        message.setIdTo(message.getIdTo());
        message.setIdFrom(message.getIdFrom());
        message.setTitle(message.getTitle());
        message.setText(message.getText());
        message.setDate(message.getDate());
        message.setStatus(true);
        return messageRepository.save(message);
    }


    @Transactional
    public List<MessageDTO> geMessageDTOList(Integer idClient, Boolean status) {
        List<Message> messagesList = messageRepository.findByIdToAndStatusOrderByDateDesc(idClient, status);
        List<MessageDTO> messageDTOList = new ArrayList<MessageDTO>();
        for (Message msg : messagesList) {
            Client client = clientRepository.getOne(msg.getIdFrom());
            MessageDTO messageDTO = new MessageDTO(client.getName(), client.getLastName(), msg, client.getId());
            messageDTOList.add(messageDTO);
        }
        return messageDTOList;
    }

    @Transactional
    public List<MessageDTO> getSentMessageDTOList(Integer idClient) {
        List<Message> messagesList = messageRepository.findByIdFromOrderByDateDesc(idClient);
        List<MessageDTO> messageDTOList = new ArrayList<MessageDTO>();
        for (Message msg : messagesList) {
            Client client = clientRepository.getOne(msg.getIdTo());
            MessageDTO messageDTO = new MessageDTO(client.getName(), client.getLastName(), msg, client.getId());
            messageDTOList.add(messageDTO);
        }
        return messageDTOList;
    }

    @Transactional
    public Message getMessage(Integer id) {
        Message message = messageRepository.findOne(id);
        return message;
    }

    @Transactional
    public Long getCountUnread(Integer id) {
        Long count = messageRepository.countByStatusAndIdTo(false, id);
        if (count == 0) {
            return null;
        } else {
            return count;
        }
    }

}
