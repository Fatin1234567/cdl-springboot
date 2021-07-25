package fatin.kazi.cdl.news;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
// models the news on the home page

@Entity
@Table(name ="news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;


    @NotNull
    @Size(min = 2,max = 14, message = "Title between 2 to 14")
    @Column(
           nullable = false
    )
    private String title;
    @NotNull
    @Size(min = 10,max = 300, message = "Description between 10 to 300")
    @Column(
            nullable = false
    )
    private String body;
    @Future(message = "Date should from future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Column(
            name = "img_path",
            nullable = false
    )
    private String imgPath;






    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDate() {
        return date;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                '}';
    }
}
