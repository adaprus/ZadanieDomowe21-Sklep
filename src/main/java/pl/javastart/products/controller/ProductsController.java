package pl.javastart.products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.javastart.products.model.Product;
import pl.javastart.products.model.ProductCategory;
import pl.javastart.products.repository.ProductsRepository;
import pl.javastart.products.service.ProductService;

import java.util.List;

@Controller
public class ProductsController {
    private ProductsRepository productsRepository;
    private ProductService productService;

    public ProductsController(ProductsRepository productsRepository, ProductService productService) {
        this.productsRepository = productsRepository;
        this.productService = productService;

    }

    @GetMapping("/lista")
    @ResponseBody
    public String printProductsList(@RequestParam(value = "kategoria", required = false) String category) {
        List<Product> productList;
        double priceSum;

        if (category != null) {
            productList = productsRepository.chosenProductsList(category);
        } else {
            productList = productsRepository.getAll();
        }
        priceSum = productService.productsPricesSum(productList, category);

        String productsInfo = "";

        for (Product p : productList) {
            productsInfo += p.toString() + "<br/>";
        }
        String priceInfo = "Suma cen wszystkich produktów: " + priceSum;

        return productsInfo + priceInfo;
    }

    @GetMapping("/add")
    @ResponseBody
    public String addProduct(@RequestParam String name,
                             @RequestParam double price,
                             @RequestParam ProductCategory category) {

        try {
            Product product = new Product(name, price, category);
            productsRepository.addProduct(product);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return "Dodano produkt";
    }
}
