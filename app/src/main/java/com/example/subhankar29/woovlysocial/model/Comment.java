package com.example.subhankar29.woovlysocial.model;

public class Comment {

    private int postId;

    private int id;

    private String name;

    private String email;

    private String body;

    public Comment(String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
