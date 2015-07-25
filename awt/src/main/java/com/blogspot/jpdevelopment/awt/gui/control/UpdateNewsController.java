package com.blogspot.jpdevelopment.awt.gui.control;

import com.blogspot.jpdevelopment.awt.domain.News;
import com.blogspot.jpdevelopment.awt.gui.model.UpdateNewsEvent;
import com.blogspot.jpdevelopment.awt.gui.model.UpdateNewsResult;
import com.blogspot.jpdevelopment.awt.newsreader.NewsReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateNewsController {

    @Autowired
    @Qualifier("schantzOfflineNewsReader")
    private NewsReader newsReader;
//    private com.blogspot.jpdevelopment.awt.newsreader_refactored.NewsReader newsReader;

    public UpdateNewsResult updateNews(UpdateNewsEvent updateNewsEvent) {
//        List<News> news = newsReader.getNews(new NewsResource(new File(System.getProperty("user.dir") + "/awt/src/main/resources/www.schantz.com.htm")));
        List<News> news = this.newsReader.getNews();
        return UpdateNewsResult.fromNews(news);
    }
}
