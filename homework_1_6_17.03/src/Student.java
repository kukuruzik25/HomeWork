import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private double rating;
    private int missedClasses;

    public Student(String name, double rating, int missedClasses) {
        this.name = name;
        this.rating = rating;
        this.missedClasses = missedClasses;
    }

    public String getName() {
        return name;
    }
    public double getRating() {
        return rating;
    }
    public int getMissedClasses() {
        return missedClasses;
    }

    @Override
    public int compareTo(Student other) {
        if (this.missedClasses != other.missedClasses) {
            return Integer.compare(this.missedClasses, other.missedClasses);
        }
        if (Double.compare(this.rating, other.rating) != 0) {
            return Double.compare(other.rating, this.rating);
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Student: " +
                "\nname - " + name +
                "\nrating - " + rating +
                "\nmissed - " + missedClasses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Double.compare(rating, student.rating) == 0 &&
                missedClasses == student.missedClasses &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, missedClasses);
    }
}