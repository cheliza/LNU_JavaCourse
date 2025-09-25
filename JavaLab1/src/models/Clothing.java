package models;
public class Clothing extends Product {
    String fabric; 
    String size;   

    public Clothing(String name, String manufacturer, double price, String fabric, String size) {
        super(name, manufacturer, price);
        this.fabric = fabric;
        this.size = size;
    }

    public String getFabric() {
        return fabric;
    }
    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "fabric='" + fabric + '\'' +
                ", size='" + size + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer=" + manufacturer +
                ", price='" + price + '\'' +
                '}';
    }
    
}
