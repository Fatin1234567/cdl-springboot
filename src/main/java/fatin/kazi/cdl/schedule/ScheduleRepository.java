package fatin.kazi.cdl.schedule;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule,Integer> {

    @Query(nativeQuery = true,value = "SELECT * " +
            "FROM Schedule " +
            "ORDER BY date " +
            "LIMIT 2")
    public List<Schedule> scheduleForDayOne();
}
