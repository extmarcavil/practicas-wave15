package com.example.linkpractice.models;

public class Link {
    Integer id;
    String link;
    Integer visits;
    Boolean valid;
    String password;

    public Link(String link, Integer visits, Boolean valid, String password) {
        this.link = link;
        this.visits = visits;
        this.valid = valid;
        this.password = password;
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

    public void setVisits(Integer visits) {
        this.visits = visits;
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
