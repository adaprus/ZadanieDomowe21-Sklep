package pl.javastart.products.service;

import org.springframework.stereotype.Service;
import pl.javastart.products.model.Product;

import java.util.List;

@Service
public class ProductService {
    public double productsPricesSum(List<Product> productList) {
        double sum = 0;

        for (Product p : productList) {
            sum += p.getPrice();
        }
        return sum;
    }
}
