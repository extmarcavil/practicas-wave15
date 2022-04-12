package generigcWrapperLambdaStreams;

public class Vehicle {
    private String model;
    private String brand;
    private Double price;

    public Vehicle(String model, String brand, Double price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public String toString() {
        return "Marca: " + this.brand + " Modelo: " + this.model + " Precio: " + this.price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
