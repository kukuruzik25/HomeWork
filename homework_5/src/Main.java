import model.UserProfile;
import processor.ProfileProcessor;

public class Main {
    public static void main(String[] args) {
        try {
            UserProfile bad = new UserProfile(
                    "никнейм_который_точно_слишком_длинный",
                    null,
                    "bio",
                    null,
                    null
            );
            ProfileProcessor.process(bad);
            System.out.println();

            UserProfile good = new UserProfile("adel", "adel@mail.ru", "bio", null, null);
            ProfileProcessor.process(good);

        } catch (IllegalAccessException e) {
            System.err.println("Ошибка доступа к полям: " + e.getMessage());
        }
    }
}