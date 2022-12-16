package com.enigmacamp.elibrary.model.request;

public class PublisherRequest {
    private String publisher_name;
    private String publisher_address;
    private Integer is_active;

    @Override
    public String toString() {
        return "PublisherRequest{" +
                "publisher_name='" + publisher_name + '\'' +
                ", publisher_address='" + publisher_address + '\'' +
                ", is_active=" + is_active +
                '}';
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getPublisher_address() {
        return publisher_address;
    }

    public void setPublisher_address(String publisher_address) {
        this.publisher_address = publisher_address;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }
}
