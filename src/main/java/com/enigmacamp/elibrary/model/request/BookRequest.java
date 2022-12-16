package com.enigmacamp.elibrary.model.request;
public class BookRequest {
    private Integer is_active;
    private String title;
    private String author;
    private String year_published;
    private String published_at;
    private String publisher_name;
    private Integer id_publisher;

    @Override
    public String toString() {
        return "BookRequest{" +
                "is_active=" + is_active +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year_published='" + year_published + '\'' +
                ", published_at='" + published_at + '\'' +
                ", publisher_name='" + publisher_name + '\'' +
                ", id_publisher=" + id_publisher +
                '}';
    }

    public Integer getId_publisher() {
        return id_publisher;
    }

    public void setId_publisher(Integer id_publisher) {
        this.id_publisher = id_publisher;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear_published() {
        return year_published;
    }

    public void setYear_published(String year_published) {
        this.year_published = year_published;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }
}
