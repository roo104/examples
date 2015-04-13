package com.blogspot.jpdevelopment.awt.newsreader;

import com.blogspot.jpdevelopment.awt.domain.News;

import java.util.List;

public interface NewsReader {

    List<News> getNews();

    void setBasePath(String basePath);
}
