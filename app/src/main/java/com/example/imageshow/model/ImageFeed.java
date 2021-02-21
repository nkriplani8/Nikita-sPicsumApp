package com.example.imageshow.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageFeed {

    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("author")
    @Expose
    private String author;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ImageFeed{" +
                "filename='" + filename + '\'' +
                ", id=" + id +
                ", author='" + author + '\'' +
                '}';
    }
}
