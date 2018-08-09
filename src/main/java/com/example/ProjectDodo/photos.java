package com.example.ProjectDodo;

public class photos {
    private int id;
    private String url;
    private String title;


    public photos(int id, String url, String title) {
        this.id = id;
        this.url = url;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitel(String title) {
        this.title = title;
    }
}

