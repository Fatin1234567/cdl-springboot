package fatin.kazi.cdl.player;


import fatin.kazi.cdl.team.Team;
import fatin.kazi.cdl.team.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;

    @GetMapping("/add")
    @PreAuthorize("hasAuthority('cdl:write')")
    public String addPlayer(Model model){
        List<Team> teamList = teamService.listAllTeam();
        model.addAttribute("teams",teamList);
        model.addAttribute("player",new Player());
        return "playerForm";
    }

    @PostMapping("/process")
    @PreAuthorize("hasAuthority('cdl:write')")
    public ModelAndView processPlayer(@ModelAttribute Player player){
        playerService.savePlayer(player);
        return new ModelAndView("redirect:/");// changes the url
    }

}
