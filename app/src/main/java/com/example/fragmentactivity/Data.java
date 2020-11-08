package com.example.fragmentactivity;

import java.io.Serializable;

public class Data implements Serializable {



    private String image;

    private String title;

    private String bodyInfo;

    public Data() {
    }

    public Data(String image, String title, String bodyInfo) {
        this.image = image;
        this.title = title;
        this.bodyInfo = bodyInfo;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodyInfo() {
        return bodyInfo;
    }

    public void setBodyInfo(String bodyInfo) {
        this.bodyInfo = bodyInfo;
    }
}