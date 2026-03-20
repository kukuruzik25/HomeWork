import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VisitorTest {

    @Test
    void testVisitorHashCodeProblem() {
        MyHashSet<Visitor> set = new MyHashSet<>();

        Visitor vasily = new Visitor("Василий", "123");
        set.add(vasily);

        assertTrue(set.contains(vasily), "Василий в множестве");

        vasily.setPassId("999");

        boolean containsAfterChange = set.contains(vasily);

        System.out.println("Результат contains после изменения passId: " + containsAfterChange);
    }
}
