package com.blogspot.jpdevelopment.awt.newsreader_refactored;

import com.blogspot.jpdevelopment.awt.domain.News;
import com.blogspot.jpdevelopment.awt.newsreader_refactored.model.NewsResource;

import java.util.List;

public interface NewsReader {

    List<News> getNews(NewsResource newsResource);

}
