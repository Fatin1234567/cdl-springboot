package fatin.kazi.cdl.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
// models the news on the home page
public class News {


    @NotNull
    @Size(min = 2,max = 14, message = "Title between 2 to 14")
    private String title;
    @NotNull
    @Size(min = 10,max = 50, message = "Description between 2 to 14")
    private String body;
    @Future(message = "Date should from future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String imgPath;







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
