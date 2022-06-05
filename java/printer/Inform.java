package com.company;

public class Inform extends Document{
    private int length;
    private int pages;
    private String name;
    private String reviewer;

    @Override
    public String toString() {
        return "Inform{" +
                "length=" + length +
                ", pages=" + pages +
                ", name='" + name + '\'' +
                ", reviewer='" + reviewer + '\'' +
                '}';
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Inform(int length, int pages, String name, String reviewer) {
        this.length = length;
        this.pages = pages;
        this.name = name;
        this.reviewer = reviewer;
    }
}
