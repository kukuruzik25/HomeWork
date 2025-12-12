public class Mage extends GameCharacter { 

	private double intelligence;
    private double spellPower;
    private String element;

    public Mage(String name,int level, double health, double mana, boolean isAlive, double intelligence, double spellPower, String element){
        super(name, level,  health,  mana,  isAlive);
        this.intelligence = intelligence;
        this.spellPower = spellPower;
        this.element =element;
    }

    @Override
    public void displayInfo(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Имя: " + name);
        System.out.println("Уровень: " + level);
        System.out.println("Здоровье: " + health);
        System.out.println("Мана: " + mana);
        System.out.println("Жив ли персонаж: " + isAlive);
        System.out.println("Интеллект жиес: " + intelligence);
        System.out.println("Cила заклинаний: " + spellPower);
        System.out.println("Стихия: " + element);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void useSpecialAbility(){
        System.out.println(getName() + " использует магический щит");
    }

    public void castSpell(String spellName){
        System.out.println(getName() + " произносит \"" + spellName+"\"");
    }

    public void meditate(){
        setMana(100);
        System.out.println(getName() + " медитирует...");
        System.out.println("Мана восстановлена");

    }
}