package fatin.kazi.cdl.news;

import fatin.kazi.cdl.news.News;
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

    List<News> newsList = new ArrayList<>();

    @GetMapping("/")
    public String showNews(Model model){
        model.addAttribute("newsList", newsList);
        return "Home";
    }
    @GetMapping("/addNews")
    public String addNews(Model model){
        model.addAttribute("news", new News());
        return "formNews";
    }

    @PostMapping("/processNews")
    public String processNews(@Valid @ModelAttribute News news, BindingResult bindingResult){

        if(bindingResult.hasErrors()) return "formNews";
        newsList.add(news);
        return "redirect:";
    }



}
