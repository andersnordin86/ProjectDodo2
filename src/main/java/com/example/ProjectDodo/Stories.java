package com.example.ProjectDodo;

import java.sql.Date;

public class Stories {

    private int id;
    private Date createddate;
    private Date lastetided;
    private String createdby;
    private String image;
    private String location;
    private String headline;
    private String storytext;

    public Stories(int id, Date createddate, Date lastetided, String createdby, String image, String location, String headline, String storytext) {
        this.id = id;
        this.createddate = createddate;
        this.lastetided = lastetided;
        this.createdby = createdby;
        this.image = image;
        this.location = location;
        this.headline = headline;
        this.storytext = storytext;
    }

    public Stories(Date createddate, String headline, String storytext) {
        this.createddate = createddate;
        this.headline = headline;
        this.storytext = storytext;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public Date getLastetided() {
        return lastetided;
    }

    public void setLastetided(Date lastetided) {
        this.lastetided = lastetided;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getStorytext() {
        return storytext;
    }

    public void setStorytext(String storytext) {
        this.storytext = storytext;
    }


}
