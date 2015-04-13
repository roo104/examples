package com.blogspot.jpdevelopment.awt.newsreader;

import static org.junit.Assert.assertTrue;

import com.blogspot.jpdevelopment.awt.AwtConfig;
import com.blogspot.jpdevelopment.awt.domain.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AwtConfig.class})
public class SchantzOnlineNewsReaderTest {

    @Autowired
    @Qualifier("schantzOnlineNewsReader")
    NewsReader schantzNewsReader;

    @Test
    public void testGetNews() throws Exception {
        List<News> news = schantzNewsReader.getNews();

        assertTrue(news.size() > 0);
    }
}