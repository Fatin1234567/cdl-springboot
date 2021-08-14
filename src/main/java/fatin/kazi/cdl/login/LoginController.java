package fatin.kazi.cdl.login;

import fatin.kazi.cdl.team.TeamService;
import fatin.kazi.cdl.user.MyUserDetails;
import fatin.kazi.cdl.user.User;
import fatin.kazi.cdl.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    TeamService teamService;

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/signup")
    public String getSigninPage(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("teams",teamService.listAllTeam());
        return "signup";
    }

    @PostMapping("/processSignup")
    public String processSignup(@ModelAttribute User user, RedirectAttributes redirectAttributes){

        boolean errors = false;
        if(userService.loginExists(user.getUserName())){
            redirectAttributes.addAttribute("loginExists","Login already exists in the database");
            errors = true;
        }
        if(errors) return "redirect:/signup";

        userService.createUserAccount(user);
        return "redirect:/login";
    }

    @GetMapping("/forbidden")
    public String forbiddenPage(){
        return "403";

    }







}
