import java.util.*;

public class YandexGoAnalysis {
    public static void main(String[] args) {

        Product product1 = new Product(1, "Яблоки");
        Product product2 = new Product(2, "Молоко");
        Product product3 = new Product(3, "Хлеб");
        Product product4 = new Product(4, "Сыр");
        Product product5 = new Product(5, "Яйца");
        Product product6 = new Product(6, "Бананы");
        Product product7 = new Product(7, "Кофе");
        Product product8 = new Product(8, "Печенье");
        Product product9 = new Product(9, "Сок");
        Product product10 = new Product(10, "Шоколад");
        List<Product> allProducts = new ArrayList<>();
        allProducts.add(product1);
        allProducts.add(product2);
        allProducts.add(product3);
        allProducts.add(product4);
        allProducts.add(product5);
        allProducts.add(product6);
        allProducts.add(product7);
        allProducts.add(product8);
        allProducts.add(product9);
        allProducts.add(product10);

        User user1 = new User(1, "Анна");
        User user2 = new User(2, "Борис");
        User user3 = new User(3, "Виктория");
        User user4 = new User(4, "Дмитрий");
        List<User> allUsers = new ArrayList<>();
        allUsers.add(user1);
        allUsers.add(user2);
        allUsers.add(user3);
        allUsers.add(user4);

        List<Order> allOrders = new ArrayList<>();

        List<Product> list1 = new ArrayList<>();
        list1.add(product1);
        list1.add(product2);
        list1.add(product3);
        allOrders.add(new Order(101, user1, list1));

        List<Product> list2 = new ArrayList<>();
        list2.add(product2);
        list2.add(product4);
        allOrders.add(new Order(102, user1, list2));

        List<Product> list3 = new ArrayList<>();
        list3.add(product6);
        list3.add(product7);
        list3.add(product8);
        allOrders.add(new Order(103, user1, list3));

        List<Product> list4 = new ArrayList<>();
        list4.add(product1);
        list4.add(product5);
        list4.add(product3);
        allOrders.add(new Order(104, user2, list4));

        List<Product> list5 = new ArrayList<>();
        list5.add(product2);
        list5.add(product9);
        list5.add(product10);
        allOrders.add(new Order(105, user2, list5));

        List<Product> list6 = new ArrayList<>();
        list6.add(product1);
        allOrders.add(new Order(106, user2, list6));

        List<Product> list7 = new ArrayList<>();
        list7.add(product4);
        list7.add(product3);
        list7.add(product2);
        allOrders.add(new Order(107, user3, list7));

        List<Product> list8 = new ArrayList<>();
        list8.add(product7);
        list8.add(product8);
        allOrders.add(new Order(108, user3, list8));

        List<Product> list9 = new ArrayList<>();
        list9.add(product1);
        list9.add(product6);
        list9.add(product9);
        allOrders.add(new Order(109, user4, list9));

        List<Product> list10 = new ArrayList<>();
        list10.add(product3);
        allOrders.add(new Order(110, user4, list10));

//1
        List<Set<Product>> userUniqueList = new ArrayList<>();
        for (int i = 0; i < allUsers.size(); i++) {
            Set<Product> unique = new HashSet<>();
            User currentUser = allUsers.get(i);
            for (int j = 0; j < allOrders.size(); j++) {
                Order currentOrder = allOrders.get(j);
                if (currentOrder.getUser().equals(currentUser)) {
                    List<Product> productsInOrder = currentOrder.getProducts();
                    for (int k = 0; k < productsInOrder.size(); k++) {
                        unique.add(productsInOrder.get(k));
                    }
                }
            }
            userUniqueList.add(unique);
        }
        int maxSize = 0;
        int maxIndex = 0;
        for (int i = 0; i < userUniqueList.size(); i++) {
            if (userUniqueList.get(i).size() > maxSize) {
                maxSize = userUniqueList.get(i).size();
                maxIndex = i;
            }
        }
        System.out.println("Пользователь с максимальным количеством уникальных товаров:");
        System.out.println(allUsers.get(maxIndex).getName() + " - " + maxSize + " товаров");
        System.out.println();

//2
        List<String> goodProducts = new ArrayList<>();

        for (int i = 0; i < allProducts.size(); i++) {
            Product currentProduct = allProducts.get(i);
            boolean allHave = true;
            for (int j = 0; j < allUsers.size(); j++) {
                User currentUser = allUsers.get(j);
                boolean userHas = false;
                for (int k = 0; k < allOrders.size(); k++) {
                    Order currentOrder = allOrders.get(k);
                    if (currentOrder.getUser().equals(currentUser)) {
                        List<Product> prods = currentOrder.getProducts();
                        for (int m = 0; m < prods.size(); m++) {
                            if (prods.get(m).equals(currentProduct)) {
                                userHas = true;
                                break;
                            }
                        }
                    }
                    if (userHas) {
                        break;
                    }
                }
                if (!userHas) {
                    allHave = false;
                    break;
                }
            }
            if (allHave) {
                goodProducts.add(currentProduct.getName());
            }
        }
        System.out.println("Товары, которые встречаются хотя бы в одном заказе каждого пользователя:");
        if (goodProducts.size() == 0) {
            System.out.println("Таких товаров нет");
        } else {
            for (int i = 0; i < goodProducts.size(); i++) {
                System.out.println(goodProducts.get(i));
            }
        }
        System.out.println();

//3
        int totalItems = 0;
        for (int i = 0; i < allOrders.size(); i++) {
            totalItems = totalItems + allOrders.get(i).getProducts().size();
        }
        double avgOverall = (double) totalItems / allOrders.size();
        System.out.println("Общее среднее: " + avgOverall + " товара на заказ");
        for (int i = 0; i < allUsers.size(); i++) {
            User currentUser = allUsers.get(i);
            int userTotal = 0;
            int userOrderCount = 0;
            for (int j = 0; j < allOrders.size(); j++) {
                Order currentOrder = allOrders.get(j);
                if (currentOrder.getUser().equals(currentUser)) {
                    userTotal = userTotal + currentOrder.getProducts().size();
                    userOrderCount++;
                }
            }
            double userAvg = (double) userTotal / userOrderCount;
            System.out.println("Пользователь " + currentUser.getName() + ": " + userAvg + " товара на заказ");
        }
        System.out.println();

//4
        int minCount = 1000000;
        for (int i = 0; i < allOrders.size(); i++) {
            int size = allOrders.get(i).getProducts().size();
            if (size < minCount) {
                minCount = size;
            }
        }
        System.out.println("Минимальное количество товаров среди всех заказов: " + minCount);
        System.out.println("Заказы с таким количеством товаров:");
        for (int i = 0; i < allOrders.size(); i++) {
            Order currentOrder = allOrders.get(i);
            if (currentOrder.getProducts().size() == minCount) {
                String names = "";
                List<Product> prods = currentOrder.getProducts();
                for (int j = 0; j < prods.size(); j++) {
                    if (j > 0) {
                        names = names + ", ";
                    }
                    names = names + prods.get(j).getName();
                }
                System.out.println("Заказ #" + currentOrder.getId() + ", " + currentOrder.getUser().getName() + ", товары: " + names);
            }
        }
        System.out.println();

 //5
        System.out.println("Самый частый товар для каждого пользователя:");
        for (int i = 0; i < allUsers.size(); i++) {
            User currentUser = allUsers.get(i);
            List<Product> allUserProducts = new ArrayList<>();
            for (int j = 0; j < allOrders.size(); j++) {
                Order currentOrder = allOrders.get(j);
                if (currentOrder.getUser().equals(currentUser)) {
                    List<Product> prods = currentOrder.getProducts();
                    for (int k = 0; k < prods.size(); k++) {
                        allUserProducts.add(prods.get(k));
                    }
                }
            }
            List<Product> uniqueProds = new ArrayList<>();
            List<Integer> counts = new ArrayList<>();
            for (int j = 0; j < allUserProducts.size(); j++) {
                Product p = allUserProducts.get(j);
                int index = -1;
                for (int k = 0; k < uniqueProds.size(); k++) {
                    if (uniqueProds.get(k).equals(p)) {
                        index = k;
                        break;
                    }
                }
                if (index == -1) {
                    uniqueProds.add(p);
                    counts.add(1);
                } else {
                    counts.set(index, counts.get(index) + 1);
                }
            }
            int maxFreq = 0;
            int maxFreqIndex = 0;
            for (int j = 0; j < counts.size(); j++) {
                if (counts.get(j) > maxFreq) {
                    maxFreq = counts.get(j);
                    maxFreqIndex = j;
                }
            }
            if (uniqueProds.size() > 0) {
                System.out.println(currentUser.getName() + " чаще всего заказывает: " + uniqueProds.get(maxFreqIndex).getName() + " (" + maxFreq + " раза)");
            } else {
                System.out.println(currentUser.getName() + " ничего не заказывал");
            }
        }
        System.out.println();

//6
        List<String> checkList = new ArrayList<>();
        checkList.add("Молоко");
        checkList.add("Хлеб");
        System.out.println("Пользователи, которые заказывали все товары из списка " + checkList + ":");
        List<String> foundUsers = new ArrayList<>();
        for (int i = 0; i < allUsers.size(); i++) {
            User currentUser = allUsers.get(i);
            Set<String> userProductNames = new HashSet<>();
            for (int j = 0; j < allOrders.size(); j++) {
                Order currentOrder = allOrders.get(j);
                if (currentOrder.getUser().equals(currentUser)) {
                    List<Product> prods = currentOrder.getProducts();
                    for (int k = 0; k < prods.size(); k++) {
                        userProductNames.add(prods.get(k).getName());
                    }
                }
            }
            boolean hasAll = true;
            for (int j = 0; j < checkList.size(); j++) {
                if (!userProductNames.contains(checkList.get(j))) {
                    hasAll = false;
                    break;
                }
            }

            if (hasAll) {
                foundUsers.add(currentUser.getName());
            }
        }
        if (foundUsers.size() == 0) {
            System.out.println("Таких пользователей нет");
        } else {
            for (int i = 0; i < foundUsers.size(); i++) {
                System.out.println(foundUsers.get(i));
            }
        }
    }
}