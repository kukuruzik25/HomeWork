import java.util.List;

class Order {
    private int id;
    private User user;
    private List<Product> products;

    public Order(int id, User user, List<Product> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public int getId() { return id; }
    public User getUser() { return user; }
    public List<Product> getProducts() { return products; }

    @Override
    public String toString() {
        return "Order: (id - " + id + ", user - " + user.getName() + ", products - " + products + ")";
    }
}