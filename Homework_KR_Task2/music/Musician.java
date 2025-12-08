public class Musician {

	private String name;
    private int skill;
    
    public Musician() {
        this("Неизвестный", 0);
    }
    
    public Musician(String name, int skill) {
        setName(name);
        setExperienceYears(experienceYears);
    }
    
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Введите имя музыканта!");
            return;
        }
        this.name = name;
    }
    
    public void setExperienceYears(int skill) {
        if (skill < 0) {
            System.out.println("Опыт не может быть отрицательным!");
            return;
        }
        this.skill = skill;
    }
    
    public String getName() {
        return name;
    }
    
    public int getSkill() {
        return skill;
    }
    
    public void loh1() {
        System.out.println(name + " репетирует...");
    }
    
    public void loh2() {
        System.out.println(name + " выступает...");
    }
}