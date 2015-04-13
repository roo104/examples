package com.blogspot.jpdevelopment.awt.newsreader_refactored;

import static org.junit.Assert.assertTrue;

import com.blogspot.jpdevelopment.awt.AwtConfig;
import com.blogspot.jpdevelopment.awt.domain.News;
import com.blogspot.jpdevelopment.awt.newsreader_refactored.model.NewsResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AwtConfig.class})
public class SchantzNewsReaderTest {

    @Autowired
    NewsReader schantzNewsReader;

    @Test
    public void testGetNews() throws Exception {
        List<News> news = schantzNewsReader.getNews(new NewsResource(new File("src/main/resources/www.schantz.com.htm")));

        assertTrue(news.size() == 55);
    }
}