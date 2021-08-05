package fatin.kazi.cdl.news;

import fatin.kazi.cdl.news.News;
import fatin.kazi.cdl.user.User;
import fatin.kazi.cdl.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
// home page where the daily information about call duty league will be stored
@Controller
public class NewsController {

    @Autowired
    UserService userService;

    List<News> newsList = new ArrayList<>();

    @GetMapping("/")
    public String showNews(Model model){
        model.addAttribute("newsList", newsList);
        return "Home";
    }
    @GetMapping("/addNews")
    @PreAuthorize("hasAuthority('cdl:write')")
    public String addNews(Model model){
        model.addAttribute("news", new News());
        return "formNews";
    }

    @PostMapping("/processNews")
    @PreAuthorize("hasAuthority('cdl:write')")
    public String processNews(@Valid @ModelAttribute News news, BindingResult bindingResult){

        if(bindingResult.hasErrors()) return "formNews";
        newsList.add(news);
        return "redirect:";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/signup")
    public String getSigninPage(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }

    @PostMapping("/processSignup")
    public String processSignup(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:";
    }



}
