package com.blogspot.jpdevelopment.awt.gui.model;


import com.blogspot.jpdevelopment.awt.domain.News;

import java.util.ArrayList;
import java.util.List;

public final class UpdateNewsResult {

    private List<String> newsList;

    private UpdateNewsResult(List<String> newsList) {
        this.newsList = newsList;
    }

    private static String formatNews(News news) {
        String context = news.getContext();
        String quote = news.getQuote();

        StringBuilder sb = new StringBuilder();
        sb.append(news.getHeadline());
        sb.append("\n");
        if (context != null) {
            sb.append(context);
            sb.append("\n");
        }
        if (quote != null) {
            sb.append(quote);
            sb.append("\n");
        }
        sb.append("\n");

        return sb.toString();
    }

    public static UpdateNewsResult fromNews(List<News> domainNews) {
        List<String> newsList = new ArrayList<>();

        for (News news : domainNews) {
            newsList.add(formatNews(news));
        }
        return new UpdateNewsResult(newsList);
    }

    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        for (String str : newsList) {
            sb.append(str);
        }

        return sb.toString();
    }
}
