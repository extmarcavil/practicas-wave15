package Entities;

import java.util.List;

public class Bill {

    private Client client;
    private List<Item> items;
    private double total;

    public Bill(Client client, List<Item> items) {
        this.client = client;
        this.items = items;
        this.total = total;
    }

    public Bill() {
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

    public double getTotal() {
        return total;
    }

    public void printBill() {
        System.out.println("Entities.Client: " + client.getName());
        for (Item item : items) {
            System.out.println("Entities.Item: " + item.getName() + " - " + item.getPrice());
        }
        System.out.println("Total: " + total);
    }

    public void calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
            this.total = total;
        }
    }

    @Override
    public String toString() {
        return "Entities.Bill{" +
                "client=" + client +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
