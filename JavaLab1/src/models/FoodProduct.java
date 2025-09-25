package models;
public class FoodProduct extends Product {
    double weight; 
    int shelfLife; // термін зберігання у днях

    public FoodProduct(String name, String manufacturer, double price, double weight, int shelfLife) {
        super(name, manufacturer, price);
        this.weight = weight;
        this.shelfLife = shelfLife;
    }

    public double getWeight() {
        return weight;
    }
    public int getShelfLife() {
        return shelfLife;
    }

    @Override
    public String toString() {
        return "FoodProduct{" +
                "weight=" + weight +
                ", shelfLife=" + shelfLife +
                ", name='" + name + '\'' +
                ", manufacturer=" + manufacturer +
                ", price='" + price + '\'' +
                '}';
    }
}
