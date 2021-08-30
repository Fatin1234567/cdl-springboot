package fatin.kazi.cdl.schedule;

import fatin.kazi.cdl.news.News;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/Schedule")
public class ScheduleController {



    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private TeamService teamService;



    @GetMapping("/1")
    public String showScheduleOne(Model model){

        List<Schedule> scheduleList = scheduleService.getDayOneSchedule();
        if(!scheduleList.isEmpty())
        {
            model.addAttribute("scheduleList", scheduleList);
        }

        return "scheduleDayOne";
    }

    @GetMapping("/2")
    public String showScheduleTwo(Model model){

        List<Schedule> scheduleList = scheduleService.getDayTwoSchedule();
        if(!scheduleList.isEmpty())
        {
            model.addAttribute("scheduleList", scheduleList);
        }

        return "scheduleDayTwo";
    }
    @GetMapping("/3")
    public String showScheduleThree(Model model){

        List<Schedule> scheduleList = scheduleService.getDayThreeSchedule();
        if(!scheduleList.isEmpty())
        {
            model.addAttribute("scheduleList", scheduleList);
        }

        return "scheduleDayThree";
    }
    @GetMapping("/4")
    public String showScheduleFour(Model model){

        List<Schedule> scheduleList = scheduleService.getDayFourSchedule();
        if(!scheduleList.isEmpty())
        {
            model.addAttribute("scheduleList", scheduleList);
        }

        return "scheduleDayFour";
    }

    @GetMapping("/addSchedule")
    @PreAuthorize("hasAuthority('cdl:write')")
    public String addSchedule(Model model){

        model.addAttribute("schedule", new Schedule());
        List<Team> teams = teamService.listAllTeam();
        model.addAttribute("teams",teams);
        return "formSchedule";
    }

    @PostMapping("/process")
    @PreAuthorize("hasAuthority('cdl:write')")
    public String processSchedule(@ModelAttribute Schedule schedule){
        scheduleService.saveSchedule(schedule);
        return "redirect:/Schedule/1";
    }





}
