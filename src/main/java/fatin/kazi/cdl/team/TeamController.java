package fatin.kazi.cdl.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/Team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/add")
    public String addTeam(Model model){
        model.addAttribute("team",new Team());
        return "formTeam";
    }

    @PostMapping("/process")
    public ModelAndView processTeam(@ModelAttribute Team team) {
        teamService.saveTeam(team);
        return new ModelAndView("redirect:/");// changes the url

    }
}
