import java.util.*;
import java.util.stream.Collectors;

public class OrderAnalysis {

    private List<User> users;
    private List<Product> products;
    private List<Order> orders;

    public OrderAnalysis(List<User> users, List<Product> products, List<Order> orders) {
        this.users = users;
        this.products = products;
        this.orders = orders;
    }

    public Set<Product> getOrdered() {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.toSet());
    }

    public Map<Product, Long> countProduct() {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(
                        product -> product,
                        Collectors.counting()
                ));
    }

    public Map<Product, Set<User>> getUsers() {
        return orders.stream()
                .flatMap(order -> order.getProducts().stream()
                        .map(product -> new AbstractMap.SimpleEntry<>(product, order.getUser())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toSet())
                ));
    }

    public Optional<Order> findLarge() {
        return orders.stream()
                .max(Comparator.comparingInt(order -> order.getProducts().size()));
    }

    public List<Map.Entry<User,Long>> getSorted() {
        Map<User,Long> count = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getUser,
                        Collectors.counting()
                ));
        return count.entrySet().stream()
                .sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .collect(Collectors.toList());
    }
}