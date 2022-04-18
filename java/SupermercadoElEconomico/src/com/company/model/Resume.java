package com.company.model;

import java.util.List;

public class Resume {
    private String id;
    private Client client;
    private List<Item> items;
    private Integer total;

    public Resume(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Resume(Client client, List<Item> items, Integer total) {
        this.client = client;
        this.items = items;
        this.total = total;
    }

    public Resume(Client client1, List<Item> listItem) {
        this.client = client1;
        this.items = listItem;
    }



    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id='" + id + '\'' +
                ", client=" + client +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
