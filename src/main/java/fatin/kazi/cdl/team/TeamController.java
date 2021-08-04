package fatin.kazi.cdl.team;

import fatin.kazi.cdl.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('cdl:write')")
    public String addTeam(Model model){
        model.addAttribute("team",new Team());
        return "formTeam";
    }

    @PostMapping("/process")
    @PreAuthorize("hasAuthority('cdl:write')")
    public ModelAndView processTeam(@ModelAttribute Team team) {
        teamService.saveTeam(team);
        return new ModelAndView("redirect:/");// changes the url

    }
    @GetMapping("/page")
    public String getTeamPage(Model model){
        model.addAttribute("teams",teamService.listAllTeam());
        return "teamPage";
    }


}
