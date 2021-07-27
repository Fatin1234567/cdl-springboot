package fatin.kazi.cdl.team;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TeamService {


    @Autowired
    TeamRepository teamRepo;

    public List<Team> listAllTeam(){
        return (List<Team>) teamRepo.findAll();
    }

    public void saveTeam(Team team){
        teamRepo.save(team);
    }





}
