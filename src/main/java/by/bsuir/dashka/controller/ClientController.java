package by.bsuir.dashka.controller;

import by.bsuir.dashka.entity.Client;
import by.bsuir.dashka.service.client.IClientService;
import by.bsuir.dashka.service.message.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static by.bsuir.dashka.utils.Literal.*;

/**
 * Created by Dashka on 04.05.2015.
 */
@Controller
public class ClientController {

    @Autowired
    private IClientService clientService;

    @Autowired
    private IMessageService messageService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showProfile(@PathVariable Integer id, ModelMap model) {
        Client client = clientService.findClient(id);
        model.addAttribute("id", id);
        model.addAttribute("client", client);
        model.addAttribute("countMess", messageService.getCountUnread(id));
        return "profile.jsp";
    }


    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editProfile(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("client", clientService.findClient(id));

        model.addAttribute("countMess", messageService.getCountUnread(id));
        return "../editProfile.jsp";
    }

    @RequestMapping(value = "/{id}/editProfile", method = RequestMethod.POST)
    public String editProfile(@PathVariable("id") Integer id,
                              @RequestParam("city") String city,
                              @RequestParam("birthday") String birthday,
                              @RequestParam("phone") String phone,
                              @RequestParam("study") String study,
                              @RequestParam("work") String work,
                              @RequestParam("aboutMe") String aboutMe,
                              ModelMap model) {
        model.addAttribute("id", id);
        clientService.update(id, city, birthday, phone, study, work, aboutMe);
        return "redirect:/{id}";
    }

    @RequestMapping(value = "/{id}/search", method = RequestMethod.GET)
    public String searcherShow(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("id", id);
        model.addAttribute("countMess", messageService.getCountUnread(id));
        return "../search.jsp";
    }

    @RequestMapping(value = "/{id}/searchUser", method = RequestMethod.POST)
    public String searchProfile(@PathVariable("id") Integer id,
                                @RequestParam("name") String name,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("city") String city,
                                @RequestParam("study") String study,
                                @RequestParam("work") String work,
                                ModelMap model) {
        model.addAttribute("id", id);
        List<Client> clientList = clientService.search(name, lastName, city, study, work);
        if (clientList.size() == 0) {
            model.addAttribute("msgSearch", MSG_SEARCH_NOT_RESULT);
        } else {
            model.addAttribute("searchResults", clientList);
        }
        model.addAttribute("countMess", messageService.getCountUnread(id));
        return "../searchResult.jsp";
    }


}
