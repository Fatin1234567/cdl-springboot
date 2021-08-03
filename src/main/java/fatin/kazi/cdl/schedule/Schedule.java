package fatin.kazi.cdl.schedule;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teamOne;
    private String teamTwo;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private  Date date;
    private String teamOneImg;
    private String teamTwoImg;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamOneImg() {
        return teamOneImg;
    }

    public void setTeamOneImg(String teamOneImg) {
        this.teamOneImg = teamOneImg;
    }

    public String getTeamTwoImg() {
        return teamTwoImg;
    }

    public void setTeamTwoImg(String teamTwoImg) {
        this.teamTwoImg = teamTwoImg;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}