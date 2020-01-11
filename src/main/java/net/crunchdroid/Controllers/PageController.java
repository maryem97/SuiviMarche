package net.crunchdroid.Controllers;

import net.crunchdroid.Dto.UserDto;
import net.crunchdroid.Entities.User;
import net.crunchdroid.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author CrunchDroid
 */
@Controller
public class PageController {

    @Autowired
    UserServiceImpl userService;

/*
    @GetMapping("/")
    public String root() {
        return "home";
    }
*/
    @RequestMapping("/login")
    public String login(Model model) {
        return "login2";
    }
/*
    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
    */


    @GetMapping("/")
    public String plainPage(Model model) {
      //  model.addAttribute("total",userService.getTotal());
        return "plain-page";
    }


    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "form-test";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") UserDto model) {

        userService.addUser(model);
        return "redirect:/getAll";
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
        List<User> listUser = userService.getAll();
        model.addAttribute("listUser", listUser);
        return "listUser";
    }

    @RequestMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") Long id,@ModelAttribute("user") UserDto model){
        userService.updateUser(id,model);
        return "redirect:/getAll";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id,Model model) throws Exception{
      User user=  userService.getUserById(id);
      model.addAttribute("user",user);

        return "editUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/getAll";
    }


}
