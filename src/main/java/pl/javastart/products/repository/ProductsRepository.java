package pl.javastart.products.repository;

import org.springframework.stereotype.Repository;
import pl.javastart.products.model.Product;
import pl.javastart.products.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepository {
    private List<Product> productList;

    public ProductsRepository() {
        this.productList = new ArrayList<>();
        productList.add(new Product("Mleko", 2.49, ProductCategory.FOOD_ITEM));
        productList.add(new Product("Makaron", 3.69, ProductCategory.FOOD_ITEM));
        productList.add(new Product("Czajnik", 99.99, ProductCategory.HOUSEHOLD_ITEM));
        productList.add(new Product("Toster", 66, ProductCategory.HOUSEHOLD_ITEM));
        productList.add(new Product("Blok rysunkowy", 3, ProductCategory.OTHER));
        productList.add(new Product("Linijka", 2, ProductCategory.OTHER));
    }

    public List<Product> getAll() {
        return productList;
    }

    public List<Product> chosenProductsList(String category) {

        List<Product> products = new ArrayList<>();

        for (Product p : productList) {
            if (p.getCategory().getDescription().equals(category)) {
                products.add(p);
            }
        }
        return products;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
