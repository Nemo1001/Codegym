package com.codegym.cms.model;



import javax.persistence.*;


@Entity
@Table(name = "Post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String writer;
    private String content;



    public Post(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;

    }

    public Post() {
    }

    @Override
    public String toString(){
        return String.format("article[id=%d, title='%s', writer='%s', content='%s', content='$s']", id, title,writer, content );
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
