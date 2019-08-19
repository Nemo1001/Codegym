package com.codegym.cms.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(targetEntity = Post.class)
    private List<Post> Post;

    public Category(String name, List<com.codegym.cms.model.Post> post) {
        this.name = name;
        Post = post;
    }

    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.codegym.cms.model.Post> getPost() {
        return Post;
    }

    public void setPost(List<com.codegym.cms.model.Post> post) {
        Post = post;
    }
}
