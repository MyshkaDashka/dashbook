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

import java.util.Set;

import static by.bsuir.dashka.utils.Literal.*;

/**
 * Created by Dashka on 13.05.2015.
 */
@Controller
public class FriendController {

    @Autowired
    private IClientService clientService;
    @Autowired
    private IMessageService messageService;

    @RequestMapping(value = "/{id}/friend", method = RequestMethod.GET)
    public String showFriends(@PathVariable Integer id, ModelMap model) {
        Set<Client> friends = clientService.getFriends(id);
        model.addAttribute("friends", friends);
        model.addAttribute("id", id);
        model.addAttribute("client", clientService.findClient(id));
        model.addAttribute("countMess", messageService.getCountUnread(id));
        return "../friends.jsp";
    }

    @RequestMapping(value = "/{id}/friend/{friendId}", method = RequestMethod.GET)
    public String showFriendProfile(@PathVariable Integer id, @PathVariable Integer friendId, ModelMap model) {
        Client client = clientService.findClient(friendId);
        model.addAttribute("id", id);
        model.addAttribute("client", client);
        model.addAttribute("countMess", messageService.getCountUnread(id));
        return "../../friendProfile.jsp";
    }


    @RequestMapping(value = "/{id}/addFriend/{idFriend}", method = RequestMethod.GET)
    public String addFriends(@PathVariable Integer id,
                             @PathVariable Integer idFriend,
                             ModelMap model) {
        if (clientService.checkFriendAdd(id, idFriend)) {
            model.addAttribute("msgFriendsStatus", MSG_USER_IN_FRIENDS);
        } else if (id.equals(idFriend)) {
            model.addAttribute("msgFriendsStatus", MSG_USER_ADD_YOURSELF);
        } else {
            clientService.addFriend(id, idFriend);
            model.addAttribute("msgFriendsStatus", MSG_ADD_FRIEND_SUCCESS);
        }
        model.addAttribute("id", id);
        model.addAttribute("client", clientService.findClient(idFriend));
        model.addAttribute("countMess", messageService.getCountUnread(id));
        return "/friendProfile.jsp";
    }

    @RequestMapping(value = "/{id}/removeFriend/{idFriend}", method = RequestMethod.GET)
    public String removeFriends(@PathVariable Integer id,
                                @PathVariable Integer idFriend,
                                ModelMap model) {
        if (!clientService.checkFriendAdd(id, idFriend)) {
            model.addAttribute("msgFriendsStatus", MSG_USER_NOT_FRIEND);
        } else {
            clientService.removeFriend(id, idFriend);
            model.addAttribute("msgFriendsStatus", MSG_USER_REMOVE_FROM_FRIEND);
        }
        model.addAttribute("friends", clientService.getFriends(id));
        model.addAttribute("id", id);
        model.addAttribute("client", clientService.findClient(id));
        model.addAttribute("removeFriend", clientService.findClient(idFriend));
        model.addAttribute("countMess", messageService.getCountUnread(id));
        return "/friends.jsp";
    }


}
