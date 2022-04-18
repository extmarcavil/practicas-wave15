package model;

import java.util.List;
import java.util.Objects;

public class Invoice {

    private final Client client;
    private final List<Item> items;
    private final double totalAmount;

    public Invoice(Client client, List<Item> items, double totalAmount) {
        this.client = client;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    public static Invoice from(Client client, List<Item> itemsToSave, double totalAmount) {
        return new Invoice(client, itemsToSave, totalAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(invoice.totalAmount, totalAmount) == 0 && Objects.equals(client, invoice.client) && Objects.equals(items, invoice.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, items, totalAmount);
    }

    public Client getClient() {
        return client;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
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
