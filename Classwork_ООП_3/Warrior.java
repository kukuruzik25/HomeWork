public class Warrior extends GameCharacter {

	private double strength;
	private double armor;
	private String weaponType;

	public Warrior(String name, int level, double health, double mana, boolean isAlive, double strength, double armor, String weaponType) {
		super(name, level, health, mana, isAlive);
		this.armor = armor;
		this.weaponType = weaponType;
	}

	@Override
	public void displayInfo() {
		System.out.println("=====Информация о персонаже=====");
		System.out.println("Имя: " + name);
		System.out.println("Уровень: " + level);
		System.out.println("Здоровье: " + health);
		System.out.println("Сила: " + strength);
		System.out.println("Броня: " + armor);
		System.out.printl();
	}

	@Override
	public void useSpecialAbility() {
		System.out.println(getName() + " использовал способность 'Берсерк'");

	}

	public void attack(String weaponType) {
		System.out.println(getName() + ": ААААААААА");
        System.out.println("Использовано оружие: " + weaponType);
	}
}