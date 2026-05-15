package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/users/user")
    public String getUserEditingPage(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user_info";
    }

    @GetMapping("/users/new")
    public String getNewUserAddingPage(Model model) {
        model.addAttribute("user", new User());
        return "user_new";
    }


    @PostMapping("/users")
    public String addUser(@ModelAttribute("user") User user, Model model) {
        userService.addUser(user);
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @PostMapping("/users/edit")
    public String changeUser(@RequestParam("id") Long id,
                             @ModelAttribute("user") User changedUser,
                             Model model) {
        userService.editUser(changedUser);
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam(value = "id") Long id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("users", userService.getUsers());
        return "users";
    }


}
