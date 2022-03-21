package pl.pawel.model;

public enum Discriminant {
    ST("Stacja"), PO("Przystanek osobowy");
    private String description;

    Discriminant(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
