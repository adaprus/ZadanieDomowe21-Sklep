package pl.javastart.products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.products.model.Product;
import pl.javastart.products.model.ProductType;
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
    public String printProductsList(@RequestParam(value = "kategoria") String category) {
        List<Product> products = productsRepository.chosenProductsList(category);
        double priceSum = productsRepository.productsPriceSum(category);

        String productsInfo = "";
        for (Product p : products) {
            productsInfo += p.toString() + "<br/>";
        }
        String priceInfo = "Suma cen wszystkich produktów: " + priceSum;

        return productsInfo + priceInfo;
    }

    @GetMapping("/add")
    @ResponseBody
    public String addProduct(@RequestParam(value = "productname") String name,
                             @RequestParam(value = "price") double price,
                             @RequestParam(value = "category") ProductType inputState) {

        try {
            Product product = new Product(name, price, inputState);
            productsRepository.addProduct(product);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return "Dodano produkt";
    }
}
