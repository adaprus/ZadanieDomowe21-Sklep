package pl.javastart.products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.products.model.Product;
import pl.javastart.products.model.ProductCategory;
import pl.javastart.products.repository.ProductsRepository;

import java.util.List;

@Controller
public class ProductsController {
    private ProductsRepository productsRepository;

    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/lista")
    @ResponseBody
    public String printProductsList(@RequestParam(value = "kategoria", required = false) String category) {
        List<Product> products;
        double priceSum;

        if (category != null) {
            products = productsRepository.chosenProductsList(category);
        } else {
            products = productsRepository.getAll();
        }
        priceSum = productsRepository.productsPriceSum(category);

        String productsInfo = "";

        for (Product p : products) {
            productsInfo += p.toString() + "<br/>";
        }
        String priceInfo = "Suma cen wszystkich produktów: " + priceSum;

        return productsInfo + priceInfo;
    }

    @GetMapping("/add")
    @ResponseBody
    public String addProduct(@RequestParam(value = "nazwa") String name,
                             @RequestParam(value = "cena") double price,
                             @RequestParam(value = "kategoria") ProductCategory category) {

        try {
            Product product = new Product(name, price, category);
            productsRepository.addProduct(product);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return "Dodano produkt";
    }
}
