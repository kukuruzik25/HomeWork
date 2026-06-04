import java.util.Objects;

public class Visitor {
    private String name;
    private String passId;

    public Visitor(String name, String passId) {
        this.name = name;
        this.passId = passId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return Objects.equals(passId, visitor.passId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(passId);
    }

    @Override
    public String toString() {
        return "Visitor{name='" + name + "', passId='" + passId + "'}";
    }
}