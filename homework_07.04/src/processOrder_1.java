import java.util.function.Consumer;
import java.util.function.Function;

public class processOrder_1 {
    public static void main(String[] args) {

        Function<String, Function<String, Consumer<String>>> sendMessage =
                key -> userId -> text -> {
                    System.out.println("ключ доступа - " + key);
                    System.out.println("идентфикатор - " + userId);
                    System.out.println("сообщение - " + text);
                };

        String myKey = "javaSWAG";
        String myUserId = "52";
        Consumer<String> send = sendMessage.apply(myKey).apply(myUserId);

        processOrder("пица с мясом", send);
        processOrder("бургир", send);
        processOrder("кофи", send);
    }

    public static void processOrder(String orderInfo, Consumer<String> sender) {
        System.out.println("Поступил заказ: " + orderInfo);
        sender.accept("Ваш заказ " + orderInfo + " принят в обработку");
    }
}
