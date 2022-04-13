package model;

import java.util.List;

public class Invoice {

    private final Client client;
    private List<Item> items;
    private double totalAmount;

    public Invoice(Client client, List<Item> items, double totalAmount) {
        this.client = client;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "client=" + client +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
