package com.example.subhankar29.woovlysocial.model;

public class Post {

    private int albumId;

    private int id;

    private String title;

    private String thumbnailUrl;

    public Post(int albumId, int id, String title, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
    }


    public int getAlbumID() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
