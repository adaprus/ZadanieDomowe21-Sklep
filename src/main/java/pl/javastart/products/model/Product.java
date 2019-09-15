package pl.javastart.products.model;

public class Product {
    private String name;
    private double price;
    private ProductCategory category;

    public Product() {
    }

    public Product(String name, double price, ProductCategory type) {
        checkPreconditions(name, price);
        this.name = name;
        this.price = price;
        this.category = type;
    }

    private void checkPreconditions(String name, double price) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Nazwa musi składać się z minimum trzech znaków");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Cena produktu musi być dodatnia");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Nazwa produktu: " + name +
                ", cena: " + price +
                ", typ: " + category.getDescription();
    }
}
