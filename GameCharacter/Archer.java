public class Archer extends GameCharacter {

    private double agility;
    private double accuracy;
    private String arrowType;

    public Archer(String name,int level, double health, double mana, boolean isAlive, double agility, double accuracy, String arrowType) {
        super(name, level, health, mana, isAlive);
        this.agility = agility;
        this.accuracy = accuracy;
        this.arrowType = arrowType;
    }


    @Override
    public void displayInfo(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Имя: " + name);
        System.out.println("Уровень: " + level);
        System.out.println("Здоровье: " + health);
        System.out.println("Мана: " + mana);
        System.out.println("Жив ли персонаж: " + isAlive);
        System.out.println("Ловкость: " + agility);
        System.out.println("Точность: " + accuracy);
        System.out.println("Тип стрел: " + arrowType);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void useSpecialAbility(){
        System.out.println(getName() + " капец всем нафик блин");
    }

    public void attack(String target, double distance){
        System.out.println("Цель " + target + " на расстоянии " + distance +" поражена");
    }

}
