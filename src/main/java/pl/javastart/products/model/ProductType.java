package pl.javastart.products.model;

public enum ProductType {
    FOOD_ITEM ("spożywcze"),
    HOUSEHOLD_ITEM ("gospodarstwa domowego"),
    OTHER ("inne");

    private String description;

    public String getDescription() {
        return description;
    }

    ProductType(String description) {
        this.description = description;
    }
}
