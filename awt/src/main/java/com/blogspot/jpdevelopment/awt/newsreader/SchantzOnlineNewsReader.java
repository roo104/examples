package com.blogspot.jpdevelopment.awt.newsreader;

import com.blogspot.jpdevelopment.awt.domain.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("schantzOnlineNewsReader")
public class SchantzOnlineNewsReader implements NewsReader {

    @Override
    public List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect("http://www.schantz.com/?page_id=2707&lang=da").get();
            Elements newsElements = doc.select("span.maintextp");
            System.out.println("Found " + newsElements.size() + " news elements");

            Iterator<Element> newsIterator = newsElements.iterator();
            while(newsIterator.hasNext()) {
                readNews(newsList, newsIterator);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newsList;
    }

    private void readNews(List<News> newsList, Iterator<Element> newsIterator) {
        Element element = newsIterator.next();
        Elements children = element.children();
        String headline = children.get(0).text();
        System.out.println("Found news with headline: "+ headline);
        News news = new News(headline);
        if (children.size() == 2) {
            String context = children.get(1).text();
            System.out.println("Found news with context: "+ context);
            news.setContext(context);
        }
        if (children.size() > 2) {
            String quote = children.get(2).text();
            System.out.println("Found news with quote: "+ quote);
            news.setQuote(quote);
        }
        newsList.add(news);
    }

    @Override
    public void setBasePath(String basePath) {

    }
}
