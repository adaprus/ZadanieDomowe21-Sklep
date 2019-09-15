package pl.javastart.products.service;

import org.springframework.stereotype.Service;
import pl.javastart.products.model.Product;

import java.util.List;

@Service
public class ProductService {
    public double productsPricesSum(List<Product> productList, String category) {
        double sum = 0;

        for (Product p : productList) {
            if (category != null) {
                if (p.getCategory().getDescription().equals(category)) {
                    sum += p.getPrice();
                }
            } else {
                sum += p.getPrice();
            }
        }
        return sum;
    }
}
