package fatin.kazi.cdl.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NewsService {

    @Autowired
    private NewsRepository repo;

    public void saveNews(News news){
        repo.save(news);
    }

    public List<News> getNewsList(){
         return (List<News>) repo.findAll();
    }
}
