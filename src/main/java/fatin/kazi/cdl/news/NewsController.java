package fatin.kazi.cdl.news;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
// home page where the daily information about call duty league will be stored
@Controller
public class NewsController {

    @Autowired
    UserService userService;

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String showNews(Model model){
        model.addAttribute("newsList", newsService.getNewsList());
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
        newsService.saveNews(news);
        return "redirect:";
    }




}
