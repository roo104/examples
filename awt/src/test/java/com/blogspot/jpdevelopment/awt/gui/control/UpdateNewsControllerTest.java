package com.blogspot.jpdevelopment.awt.gui.control;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.blogspot.jpdevelopment.awt.domain.News;
import com.blogspot.jpdevelopment.awt.gui.model.UpdateNewsEvent;
import com.blogspot.jpdevelopment.awt.gui.model.UpdateNewsResult;
import com.blogspot.jpdevelopment.awt.newsreader.NewsReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class UpdateNewsControllerTest {

    @InjectMocks
    UpdateNewsController updateNewsController;

    @Mock
    NewsReader newsReader;

    @Test
    public void testUpdateNews() throws Exception {
        // GIVEN
        ArrayList<News> newses = new ArrayList<News>();
        News news = new News("headline");
        news.setContext("context");
        news.setQuote("quote");
        newses.add(news);

        //WHEN
        when(this.newsReader.getNews()).thenReturn(newses);
        UpdateNewsResult result = this.updateNewsController.updateNews(new UpdateNewsEvent());

        // THEN
        assertEquals("headline\ncontext\nquote\n\n", result.prettyPrint());
    }
}