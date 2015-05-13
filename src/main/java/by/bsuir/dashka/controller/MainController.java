package by.bsuir.dashka.controller;

import by.bsuir.dashka.dto.UserDTO;
import by.bsuir.dashka.entity.User;
import by.bsuir.dashka.service.client.IClientService;
import by.bsuir.dashka.service.message.IMessageService;
import by.bsuir.dashka.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

import static by.bsuir.dashka.utils.Literal.*;

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

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String goToProfile(Principal principal, ModelMap model) {
        User user = userService.authUser(principal.getName());
        Integer id = user.getClient().getId();
        model.addAttribute("id", id);
        return "redirect:/{id}";
    }

    @RequestMapping(value = "/registrations", method = RequestMethod.POST)
    public String goToRegistration(@RequestParam("email") String login,
                                   @RequestParam("pass") String pass,
                                   @RequestParam("name") String name,
                                   @RequestParam("lastName") String lastName,
                                   ModelMap model) {
        UserDTO userDTO = new UserDTO(name, lastName, login);
        if (userService.authUser(login) != null) {
            model.addAttribute("user", userDTO);
            model.addAttribute("error", ERROR_LOGIN_MESSAGE);
            return "registration.jsp";
        }
        User user = userService.save(login, pass, "USER");
        clientService.save(name, lastName, user);
        model.addAttribute("msgSuccess", MSG_REGISTRATION_SUCCESS);
        return "authorization.jsp";
    }


}
