package by.bsuir.dashka.controller;

import by.bsuir.dashka.entity.Client;
import by.bsuir.dashka.entity.Message;
import by.bsuir.dashka.service.client.IClientService;
import by.bsuir.dashka.service.message.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * Created by Dashka on 04.05.2015.
 */
@Controller
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IClientService clientService;

    @RequestMapping(value = "/{id}/sendmessage", method = RequestMethod.GET)
    public String showMessages(@PathVariable Integer id, ModelMap model){
        Client client = clientService.findClient(id);
        model.addAttribute("id", id);
        model.addAttribute("client", client);
        Set<Client> friends = clientService.getFriends(id);
        model.addAttribute("friends", friends);
        return "../message.jsp";
    }

    @RequestMapping(value = "/{id}/sendMessage", method = RequestMethod.POST)
    public String messanger(@PathVariable("id") Integer from,
                            @RequestParam("to") Integer to,
                            @RequestParam("title") String title,
                            @RequestParam("text") String text,
                            ModelMap model) {
        messageService.save(to, from, title, text);
        return "redirect:/{id}";
    }

    @RequestMapping(value = "/{id}/message", method = RequestMethod.GET)
    public String getMessageShow(@PathVariable Integer id, ModelMap model){
        model.addAttribute("unreadMessDTO", messageService.geMessageDTOList(id, false));
        model.addAttribute("readMessDTO", messageService.geMessageDTOList(id, true));
        model.addAttribute("id", id);
        return "../messageShow.jsp";
    }

    @RequestMapping(value = "/{id}/msgunread", method = RequestMethod.GET)
    public String getMessageUnreadShow(@PathVariable Integer id, ModelMap model){
        model.addAttribute("unreadMessDTO", messageService.geMessageDTOList(id, false));
        model.addAttribute("id", id);
        return "../messageShow.jsp";
    }

    @RequestMapping(value = "/{id}/msgsent", method = RequestMethod.GET)
    public String getMessageSentShow(@PathVariable Integer id, ModelMap model){
        model.addAttribute("readMessDTO", messageService.getSentMessageDTOList(id));
        model.addAttribute("id", id);
        return "../messageShow.jsp";
    }

}
