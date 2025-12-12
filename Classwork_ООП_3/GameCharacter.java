public abstract class GameCharacter {

	private String name;
	private int level;
	private double health;
	private double mana;
	private boolean isAlive;

	private static int totalCharacters;
	public final MAX_LEVEL = 100;

	public GameCharacter() {
		this("Про", 1, 100, 0, true);
	}

	public GameCharacter(String name, int level, double health, double mana, boolean isAlive) {
		this.name =name;
		this.level = level;
		this.health = health;
		this.mana = mana;
		this.isAlive = isAlive;
		totalCharacters++;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setLevel(int level) {
		if (level <= MAX_LEVEL) {
			this.level = level;
		}
	}
	public void setHealth(double health) {
		this.health = health;
	} 
	public void setMana(double mana) {
		this.mana = mana;
	}
	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getName() {
		return this.name;
	}
	public int getLevel() {
		return this.level;
	}
	public double getHealth() {
		return this.health;
	}
	public double getMana() {
		return this.mana;
	}
	public boolean isAlive() {
		return this.isAlive;
	}

	public static int getTotalCharacters() {
		return this.totalCharacters;
	}

	public abstract void displayInfo();

	public abstract void useSpecialAbility();

	public void attack() {
		System.out.printl("Персонаж " + name + " аттакует!");
	}

	public void takeDamage(double damage) {
		health -= damage;
		if (health < 0) {
			health = 0;
			isAlive = false;
			System.out.printl("Персонаж " + name + " умер...R.I.P.");
		}
	}

	public void heal(double amount) {
		health += amount;
		System.out.printl("Урааа! " + name + " восстановил здоровье");
	}
}