package fatin.kazi.cdl.user;


import fatin.kazi.cdl.team.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.Optional;

@Controller
@Transactional
public class UserController {

    @Autowired
    private UserRepository userRepo;


    @GetMapping("/userTeam")
    public String userTeam(@AuthenticationPrincipal MyUserDetails currentUser, Model model){
        Optional<User> user = userRepo.findByUserName(currentUser.getUsername());

        model.addAttribute("user",user.get());
        return "userTeam";
    }

    @GetMapping("/userPlayer")
    public String userPlayer(@AuthenticationPrincipal MyUserDetails currentUser, Model model){
        Optional<User> user = userRepo.findByUserName(currentUser.getUsername());
        model.addAttribute("user",user.get());
        return "userPlayer";
    }



}
