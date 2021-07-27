package fatin.kazi.cdl.schedule;

import fatin.kazi.cdl.news.News;
import fatin.kazi.cdl.team.Team;
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

    List<Schedule> scheduleList = new ArrayList<>();
    List<Team> teams;

    @GetMapping("/1")
    public String showScheduleOne(Model model){
        model.addAttribute("scheduleList",scheduleList);
        return "scheduleDayOne";
    }

    @GetMapping("/addSchedule")
    public String addSchedule(Model model){
        model.addAttribute("schedule", new Schedule());
        teams = Arrays.asList(
                new Team("Optic","https://images.blz-contentstack.com/v3/assets/bltdc5337d93fbb677e/blt1f1b0a0c42f3b76d/5fac32049fbb9857903d9630/cdl_og_chi_icon_green.png"),
                new Team("Faze","https://images.blz-contentstack.com/v3/assets/blta7b34f1f894a2422/blt6ec730c1178cc1cd/5dd596f49147457fdde604ba/ATL-FAZ_Primary-Logo.png")
        );
        model.addAttribute("teams",teams);
        return "formSchedule";
    }

    @PostMapping("/process")
    public String processSchedule(@ModelAttribute Schedule schedule){
        scheduleList.add(schedule);
        return "redirect:/Schedule/1";
    }



    @GetMapping("/2")
    public String showScheduleTwo(){
        return "scheduleDayOne";
    }
    @GetMapping("/3")
    public String showScheduleThree(){
        return "scheduleDayOne";
    }
    @GetMapping("/4")
    public String showScheduleFour(){
        return "scheduleDayOne";
    }

}
