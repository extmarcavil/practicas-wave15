package Entities;

public class Item {

    private String name;
    private String code;
    private int boughtQuantity;
    private double price;

    public Item(String name, int boughtQuantity, double price) {
        this.name = name;
        this.boughtQuantity = boughtQuantity;
        this.price = price * boughtQuantity;
        this.code = this.code = "SME" + "-" + this.name.substring(0, 3).toUpperCase();
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }


    public int getBoughtQuantity() {
        return boughtQuantity;
    }

    public void setBoughtQuantity(int boughtQuantity) {
        this.boughtQuantity = boughtQuantity;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Entities.Item{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", boughtQuantity=" + boughtQuantity +
                ", price=" + price +
                '}';
    }
}
