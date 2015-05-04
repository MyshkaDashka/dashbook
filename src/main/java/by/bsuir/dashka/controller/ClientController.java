package by.bsuir.dashka.controller;

import by.bsuir.dashka.entity.Client;
import by.bsuir.dashka.service.client.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * Created by Dashka on 04.05.2015.
 */
@Controller
public class ClientController {
    @Autowired
    private IClientService clientService;

//    @RequestMapping(value = "/friends/{id}", method = RequestMethod.GET)
//    public String showFriends(@PathVariable Integer id, ModelMap model) {
//        Set<Client> friends = clientService.getFriends(id);
//        model.addAttribute("friends", friends);
//        return "redirect:/friends.jsp";
//    }

    @RequestMapping(value = "/friend", method = RequestMethod.GET)
    public String showFriendsNoId(ModelMap model) {
        Set<Client> friends = clientService.getFriends(4);
        model.addAttribute("friends", friends);
        return "friends.jsp";
    }

    @RequestMapping(value = "/friendSuccess", method = RequestMethod.GET)
    public String addFriends(@RequestParam("idClient") Integer idClient,
                             @RequestParam("idFriend") Integer idFriend,
                             ModelMap model) {
        clientService.addFriend(idClient, idFriend);
        return "addFriendSuccess.jsp";
    }

}
