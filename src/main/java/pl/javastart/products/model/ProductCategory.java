package pl.javastart.products.model;

public enum ProductCategory {
    FOOD_ITEM ("spozywcze"),
    HOUSEHOLD_ITEM ("domowe"),
    OTHER ("inne");

    private String description;

    public String getDescription() {
        return description;
    }

    ProductCategory(String description) {
        this.description = description;
    }
}
