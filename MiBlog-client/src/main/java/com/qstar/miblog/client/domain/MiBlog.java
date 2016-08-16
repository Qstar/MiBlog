package com.qstar.miblog.client.domain;

public class MiBlog {

    private Long author;

    private String content;

    private Long time;

    public MiBlog() {
    }

    public MiBlog(Long author, String content, Long time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
