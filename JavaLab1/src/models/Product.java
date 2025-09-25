package models;
 
public abstract  class Product {
    String name;
    String manufacturer;
    double price;

    public Product(String name, String manufacturer, double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", manufacturer=" + manufacturer +
                ", price='" + price + '\'' +
                '}';
    }

    
}