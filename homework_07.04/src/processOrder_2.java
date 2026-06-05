import java.util.function.Function;

public class processOrder_2 {
    public static void main(String[] args) {

        Function<String, String> removeSpaces = x -> x.trim();
        Function<String, String> makeLower = x -> x.toLowerCase();
        Function<String, String> capitalizeFirst = word -> {
            if (word.isEmpty() || word == null) {
                return word;
            }
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        };
        Function<String, String> fullFormat = removeSpaces.andThen(makeLower).andThen(capitalizeFirst);
        Function<String, String> simpleFormat = removeSpaces.andThen(makeLower);

        String example = "попик попикович";
        System.out.println("полная обработка " + fullFormat.apply(example));
        System.out.println("простая обработка " + simpleFormat.apply(example));
    }
}
