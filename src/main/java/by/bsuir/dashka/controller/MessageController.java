package by.bsuir.dashka.controller;

import by.bsuir.dashka.entity.Message;
import by.bsuir.dashka.service.message.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Dashka on 04.05.2015.
 */
@Controller
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String messanger(@RequestParam("to") Integer to,
                            @RequestParam("title") String title,
                            @RequestParam("text") String text,
                            ModelMap model) {
        Integer from = 3;
        Message message = messageService.save(to, from, title, text);
        return "message.jsp";
    }
}
