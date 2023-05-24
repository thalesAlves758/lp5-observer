public class Product extends ProductObservable {
    private String name;
    private float price;

    public Product(String name, float price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Product setPrice(float price) {
        Product oldProduct = new Product(this.name, this.price);
        this.price = price;
        this.notifyObservers(oldProduct, this);
        return this;
    }
}
