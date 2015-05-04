package by.bsuir.dashka.service.message;

import by.bsuir.dashka.entity.Message;
import by.bsuir.dashka.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Dashka on 04.05.2015.
 */
@Service
public class MessageService implements IMessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Transactional
    public Message save(Integer to, Integer from, String title, String text) {
        Message message = new Message();
        message.setIdTo(to);
        message.setIdFrom(from);
        message.setTitle(title);
        message.setText(text);
        long curTime = System.currentTimeMillis();
        Date curDate = new Date(curTime);
        message.setDate(curDate);
        message.setStatus(false);
        return messageRepository.save(message);
    }
}
