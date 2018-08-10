package com.example.ProjectDodo;

public class Calendar {
    private String start;
    private String title;
    private String description;

    public Calendar(String start, String title, String description) {
        this.start = start;
        this.title = title;
        this.description = description;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

