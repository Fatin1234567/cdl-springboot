package fatin.kazi.cdl.schedule;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule,Integer> {

    @Query(nativeQuery = true,value = "SELECT * " +
            "FROM schedule " +
            "ORDER BY date " +
            "LIMIT 2")
    public List<Schedule> scheduleForDayOne();

    @Query(nativeQuery = true,value = "SELECT * " +
            "FROM schedule " +
            "ORDER BY date " +
            "LIMIT 2,2")
    public List<Schedule> scheduleForDayTwo();

    @Query(nativeQuery = true,value = "SELECT * " +
            "FROM schedule " +
            "ORDER BY date " +
            "LIMIT 4,2")
    public List<Schedule> scheduleForDayThree();

    @Query(nativeQuery = true,value = "SELECT * " +
            "FROM schedule " +
            "ORDER BY date " +
            "LIMIT 6,2")
    public List<Schedule> scheduleForDayFour();
}
