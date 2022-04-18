package com.company;

import java.util.List;
import java.util.Map;

public class Resume {
    private String id;
    private Client client;
    private Map<String, Item> items;
    private Integer total;

    public Resume(){

    }

    public Resume(Client client, Map<String, Item> items, Integer total) {
        this.client = client;
        this.items = items;
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Map<String, Item> getItems() {
        return items;
    }

    public void setItems(Map<String, Item> items) {
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
