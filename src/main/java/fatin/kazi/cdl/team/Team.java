package fatin.kazi.cdl.team;

import fatin.kazi.cdl.player.Player;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "team_detail")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teamName;
    private String logoPath;
    private String color;
    @Column( columnDefinition="TEXT")
    private String description;


    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> playerList;

    public Team() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Team(String teamName, String logoPath) {
        this.teamName = teamName;
        this.logoPath = logoPath;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    @Override
    public String toString() {
        return "teamName";
    }
}
