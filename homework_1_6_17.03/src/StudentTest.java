import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private List<Student> students;
    private Random random;

    @BeforeEach
    void setUp() {
        random = new Random(42);
        students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String name = generateRandomName();
            double rating = 1.0 + random.nextDouble() * 4.0;
            int missedClasses = random.nextInt(30);
            students.add(new Student(name, rating, missedClasses));
        }
    }
    private String generateRandomName() {
        String[] names = {"Анна", "Борис", "Виктория", "Глеб", "Дарья", "Егор", "Жанна", "Захар", "Ирина", "Кирилл",
                "Людмила", "Михаил", "Наталья", "Олег", "Полина", "Роман", "Светлана", "Тимофей", "Ульяна", "Фёдор",
                "Христина", "Юрий", "Ярослав", "Алина", "Денис", "Елена", "Максим", "Ольга", "Павел", "Татьяна"};
        return names[random.nextInt(names.length)] + random.nextInt(100);
    }

    @Test
    void testComparable() {
        Collections.sort(students);
        int minMissed = Integer.MAX_VALUE;
        for (Student s : students) {
            if (s.getMissedClasses() < minMissed) {
                minMissed = s.getMissedClasses();
            }
        }
        assertEquals(minMissed, students.get(0).getMissedClasses(),
                "Первый студент должен иметь минимальное количество пропусков");
        for (int i = 0; i < students.size() - 1; i++) {
            Student current = students.get(i);
            Student next = students.get(i + 1);
            if (current.getMissedClasses() == next.getMissedClasses()) {
                assertTrue(current.getRating() >= next.getRating(),
                        "При равных пропусках студент с бОльшим рейтингом должен быть выше");
                if (Math.abs(current.getRating() - next.getRating()) < 0.0001) {
                    assertTrue(current.getName().compareTo(next.getName()) <= 0,
                            "При равных пропусках и рейтинге порядок по алфавиту");
                }
            }
            else {
                assertTrue(current.getMissedClasses() < next.getMissedClasses(),
                        "Студент с меньшим количеством пропусков должен быть выше");
            }
        }
        System.out.println("testComparable пройден успешно!");
    }

    @Test
    void testUtilityComparator() {
        Comparator<Student> utilityComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                double score1 = (s1.getRating() * 0.7) - (s1.getMissedClasses() * 0.1);
                double score2 = (s2.getRating() * 0.7) - (s2.getMissedClasses() * 0.1);
                return Double.compare(score2, score1);
            }
        };
        students.sort(utilityComparator);
        for (int i = 0; i < students.size() - 1; i++) {
            Student current = students.get(i);
            Student next = students.get(i + 1);
            double scoreCurrent = (current.getRating() * 0.7) - (current.getMissedClasses() * 0.1);
            double scoreNext = (next.getRating() * 0.7) - (next.getMissedClasses() * 0.1);
            assertTrue(scoreCurrent >= scoreNext,
                    "Студент с индексом " + i + " должен иметь score >= чем следующий");
        }
        System.out.println("testUtilityComparator пройден успешно!");
    }

    @Test
    void testIteratorLogic() {
        List<Student> mainList = new ArrayList<>(students);
        List<Student> badStudents = new ArrayList<>();
        Iterator<Student> iterator = mainList.iterator();
        int removedCount = 0;
        while (iterator.hasNext()) {
            Student s = iterator.next();
            double rating = s.getRating();
            int missed = s.getMissedClasses();
            if (rating < 2.0 && missed > 15) {
                iterator.remove();
                removedCount++;
            }
            else if (rating < 2.0 && missed <= 15) {
                iterator.remove();
                removedCount++;
                badStudents.add(s);
            }
        }
        for (Student s : mainList) {
            assertTrue(s.getRating() >= 2.0,
                    "В основном списке не должно быть студентов с рейтингом < 2.0");
        }
        assertEquals(students.size() - removedCount, mainList.size(),
                "Размер основного списка должен уменьшиться на количество удалённых студентов");
        for (Student s : badStudents) {
            assertTrue(s.getRating() < 2.0,
                    "badStudents должен содержать только студентов с rating < 2.0");
            assertTrue(s.getMissedClasses() <= 15,
                    "badStudents должен содержать только студентов с missedClasses <= 15");
        }
        System.out.println("Удалено/перенесено студентов: " + removedCount);
        System.out.println("Осталось в основном списке: " + mainList.size());
        System.out.println("В списке badStudents: " + badStudents.size());
    }
}