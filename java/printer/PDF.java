package com.company;

public class PDF extends Document{
    private int pages;
    private String title;
    private String name;
    private  String genre;

    @Override
    public String toString() {
        return "PDF{" +
                "pages=" + pages +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public PDF(int pages, String title, String name, String genre) {
        this.pages = pages;
        this.title = title;
        this.name = name;
        this.genre = genre;
    }
}
