package by.bsuir.dashka.service.message;

import by.bsuir.dashka.entity.Message;

/**
 * Created by Dashka on 04.05.2015.
 */
public interface IMessageService {

    public Message save(Integer to, Integer from, String title, String text);
}
