package com.blogspot.jpdevelopment.awt.newsreader_refactored.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class NewsResource {

    private String url;
    private File file;

    public NewsResource(String url) {
        this.url = url;
    }

    public NewsResource(File file) {
        this.file = file;
    }

    public Document readDocument() throws IOException {
        Document document = null;
        if (url != null) {
            document = Jsoup.connect("http://www.schantz.com/?page_id=2707&lang=da").get();
        } else if (file != null) {
            document = Jsoup.parse(file, "UTF-8", "http://www.schantz.com/");
        }

        return document;
    }

}
