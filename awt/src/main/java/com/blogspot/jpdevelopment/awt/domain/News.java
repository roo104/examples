package com.blogspot.jpdevelopment.awt.domain;

public class News {

    private final String headline;
    private String context;
    private String quote;

    public News(String headline) {
        this.headline = headline;
    }

    public String getHeadline() { return this.headline; }

    public String getContext() {
        return this.context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getQuote() {
        return this.quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

}
