package by.bsuir.dashka.controller;

import by.bsuir.dashka.entity.Client;
import by.bsuir.dashka.entity.Message;
import by.bsuir.dashka.entity.User;
import by.bsuir.dashka.service.client.IClientService;
import by.bsuir.dashka.service.message.IMessageService;
import by.bsuir.dashka.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Dashka on 25.04.2015.
 */
@Controller
public class MainController {

    @Autowired
    private IClientService clientService;

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "authorization.jsp";
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public String goToProfile(@RequestParam("login") String login,
                              @RequestParam("pass") String pass, Principal principal, ModelMap model) {
        List<User> userList = userService.authUser(login, pass);
        User user = userList.get(0);
        Integer idClient = user.getClient().getId();
        Client client = clientService.findClient(idClient);
        model.addAttribute("client", client);
        return "profile.jsp";
    }

    @RequestMapping(value = "/registrations", method = RequestMethod.POST)
    public String goToRegistration(@RequestParam("email") String login,
                                   @RequestParam("pass") String pass,
                                   @RequestParam("name") String name,
                                   @RequestParam("lastName") String lastName,
                                   ModelMap model) {
        User user = userService.save(login, pass, "USER");
        Client client = clientService.save(name, lastName, user);
        return "redirect:profile.jsp";
    }


}
