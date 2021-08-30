package fatin.kazi.cdl.schedule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    ScheduleRepository repo;

    public List<Schedule> listAllSchedule(){
        return (List<Schedule>) repo.findAll();
    }

    public void saveSchedule(Schedule schedule){
        repo.save(schedule);
    }

    public List<Schedule> getDayOneSchedule(){
        return repo.scheduleForDayOne();
    }
    public List<Schedule> getDayTwoSchedule(){
        return repo.scheduleForDayTwo();
    }
    public List<Schedule> getDayThreeSchedule(){
        return repo.scheduleForDayThree();
    }
    public List<Schedule> getDayFourSchedule(){
        return repo.scheduleForDayFour();
    }
}
