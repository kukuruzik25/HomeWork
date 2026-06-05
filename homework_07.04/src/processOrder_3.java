import java.util.function.Predicate;

public class processOrder_3 {
    public static void main(String[] args) {

        Predicate<String> checkLength = text -> text.length() < 5;
        Predicate<String> checkSpam = text -> text.toLowerCase().contains("buy");
        Predicate<String> checkUpperCase = text -> text.equals(text.toUpperCase());

        Predicate<String> filterRule = checkLength.negate().and(checkUpperCase.or(checkSpam));

        validateComment("buy", filterRule);
        validateComment("hello", filterRule);
        validateComment("java52", filterRule);
        validateComment("JAVA67", filterRule);
    }

    public static void validateComment(String msg, Predicate<String> rule) {
        if (rule.test(msg)) {
            System.out.println("Заблокировано");
        } else {
            System.out.println("Одобрено");
        }
    }
}
