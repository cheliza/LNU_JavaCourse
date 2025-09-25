import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import models.Clothing;
import models.FoodProduct;
import models.Product;
import services.MatrixPalindrome;
import services.ProductManager;
import services.WordProcessor;

public class tasks {
    public static void task1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рядків: ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");            
            }
            System.out.println();
        }

        int[] result = MatrixPalindrome.processMatrix(matrix);

        System.out.println("Вектор максимальних простих у кожному стовпці:");
        for (int val : result) {
            System.out.print(val + " ");
        }

        scanner.close();
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть рядок слів, розділених комами: ");
        String lineStr = scanner.nextLine();

        String processed = WordProcessor.processWords(lineStr);
        System.out.print("Оброблений рядок: " + processed);

        scanner.close();
    }

    public static void task3() {
        Scanner scanner = new Scanner(System.in);

        Product[] products = new Product[] {
            // Продовольчі товари
            new FoodProduct("Milk", "BrandA", 2.5, 1.0, 10),
            new FoodProduct("Cheese", "BrandB", 5.0, 0.5, 20),
            new FoodProduct("Bread", "BrandC", 1.5, 0.3, 5),
            new FoodProduct("Butter", "BrandD", 3.0, 0.2, 15),
            new FoodProduct("Apple", "BrandE", 0.8, 0.2, 30),

            // Одяг
            new Clothing("T-Shirt", "BrandH", 15.0, "Cotton", "M"),
            new Clothing("Jeans", "BrandI", 40.0, "Denim", "L"),
            new Clothing("Jacket", "BrandJ", 60.0, "Leather", "M"),
            new Clothing("Dress", "BrandK", 50.0, "Silk", "S"),
            new Clothing("Sweater", "BrandL", 35.0, "Wool", "L"),
        };

        List<Product> productsList = Arrays.asList(products);
        ProductManager manager = new ProductManager(productsList);

        // Сортування за ціною
        manager.sortByPrice();
        System.out.println("Відсортовані товари за ціною:");
        for (Product edition : productsList) {
            System.out.println(edition.getName());
        }

        // Пошук одягу за розміром
        System.out.print("\nВведіть розмір одягу для пошуку: ");
        String targetSize = scanner.nextLine();
        List<Clothing> findedClothing = manager.findClothingBySize(targetSize);
        System.out.println("\nЗнайдений одяг розміру " + targetSize + ":");
        for (Clothing c : findedClothing) {
            System.out.println(c);
        }

        // Продовольчі товари з максимальним терміном зберігання
        List<Product> topFood = manager.findFoodWithMaxShelfLife();
        System.out.println("\nПродовольчі товари з максимальним терміном зберігання:");
        for (Product f : topFood) {
            System.out.println(f);
        }

        scanner.close();

    }
}
