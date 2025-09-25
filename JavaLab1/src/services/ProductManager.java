package services;
import java.util.*;

import models.Clothing;
import models.FoodProduct;
import models.Product;

public  class ProductManager {
    private List<Product> products;

    public ProductManager(List<Product> products) {
        this.products = products;
    }
    
    public void sortByPrice() {
        products.sort(Comparator.comparing(Product::getPrice));
    }

    public List<Clothing> findClothingBySize(String targetSize) {
        List<Clothing> result = new ArrayList<>();
    
        for (Product prod : products) {
            if (prod instanceof Clothing) {
                Clothing clothing = (Clothing) prod;
                if (clothing.getSize().equalsIgnoreCase(targetSize)) {
                    result.add(clothing);
                }
            }
        }
        return result;
    }

    public List<Product> findFoodWithMaxShelfLife() {
        List<Product> result = new ArrayList<>();

        int maxShelfLife = 0;
        for(Product prod: products){
            if(prod instanceof FoodProduct){
                FoodProduct food = (FoodProduct) prod;
                if(food.getShelfLife() > maxShelfLife){
                    maxShelfLife = food.getShelfLife();
                }
            }
        }

        for(Product prod: products){
            if(prod instanceof FoodProduct){
                FoodProduct food = (FoodProduct) prod;
                if(food.getShelfLife() == maxShelfLife){
                    result.add(food);
                }
            }
        }
        return result;
    }
}
