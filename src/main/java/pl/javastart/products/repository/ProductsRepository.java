package pl.javastart.products.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.products.model.Product;
import pl.javastart.products.model.ProductType;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepository {
    private List<Product> productList;

    public ProductsRepository() {
        this.productList = new ArrayList<>();
        productList.add(new Product("Mleko", 2.49, ProductType.FOOD_ITEM));
        productList.add(new Product("Makaron", 3.69, ProductType.FOOD_ITEM));
        productList.add(new Product("Czajnik", 99.99, ProductType.HOUSEHOLD_ITEM));
        productList.add(new Product("Toster", 66, ProductType.HOUSEHOLD_ITEM));
        productList.add(new Product("Blok rysunkowy", 3, ProductType.OTHER));
        productList.add(new Product("Linijka", 2, ProductType.OTHER));
    }

    public List<Product> chosenProductsList(@RequestParam(value = "kategoria") String category) {

        List<Product> products = new ArrayList<>();

        switch (category) {
            case "wszystkie":
                products = productList;
                break;
            case "spozywcze":
                for (Product p : productList) {
                    if (p.getType() == ProductType.FOOD_ITEM) {
                        products.add(p);
                    }
                }
                break;
            case "domowe":
                for (Product p : productList) {
                    if (p.getType() == ProductType.HOUSEHOLD_ITEM) {
                        products.add(p);
                    }
                }
                break;
            case "inne":
                for (Product p : productList) {
                    if (p.getType() == ProductType.OTHER) {
                        products.add(p);
                    }
                }
                break;
        }
        return products;
    }

    public double productsPriceSum(@RequestParam(value = "kategoria") String category) {
        double sum = 0;

        switch (category) {
            case "wszystkie":
                for (Product p : productList) {
                    sum += p.getPrice();
                }
                break;
            case "spozywcze":
                for (Product p : productList) {
                    if (p.getType() == ProductType.FOOD_ITEM) {
                        sum += p.getPrice();
                    }
                }
                break;
            case "domowe":
                for (Product p : productList) {
                    if (p.getType() == ProductType.HOUSEHOLD_ITEM) {
                        sum += p.getPrice();
                    }
                }
                break;
            case "inne":
                for (Product p : productList) {
                    if (p.getType() == ProductType.OTHER) {
                        sum += p.getPrice();
                    }
                }
                break;
        }
        return sum;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
