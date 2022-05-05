package com.example.linkpractice.models;

public class Link {
    Integer id;
    String link;
    Integer visits;
    Boolean valid;
    String password;

    public Link(String link) {
        this.link = link;
        valid = true;
        visits = 0;
    }

    public Link(String link, String password) {
        this.link = link;
        this.password = password;
        valid = true;
        visits = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getVisits() {
        return visits;
    }

    public void sumVisit() {
        this.visits++;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
