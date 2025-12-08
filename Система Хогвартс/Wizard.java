/*
● String name — имя
● int mana — количество маны (0–100)
● int age — возраст
● int spellPower — сила заклинаний (0–50) – показатель магической мощности, увеличивается при использовании заклинаний

● void castSpell(String spellName) - Уменьшает ману на 10, увеличивает spellPower на 5
● void castSpell() - кастует «Lumos», уменьшает ману на 5, увеличивает spellPower на 3
● void castSpell(String spellName, int power) - уменьшает ману на power, увеличивает spellPower на power
● void displayInfo() - Выводит все поля + статус
● void rechargeMana(int amount) - Увеличивает ману, максимум 100
● private static int totalWizards — увеличивается при создании
нового волшебника
● private static int totalSpellPower — суммарная сила заклинаний
всех волшебников
● static void showAcademyStats() — выводит общее количество
волшебников и суммарную силу

*/
public abstract class Wizard {

	private static int totalWizards = 0;
	private static int totalSpellPower = 0;

	private String name;
	private int mana;
	private int age;
	private int spellPower;

	public Wizard() {
		this("Unknown", 50, 11,10);
	}

	public Wizard(String name, int mana, int age, int spellPower) {
		this.name = name;
		setMana(mana);
		setAge(age);
		setSpellPower(spellPower);
		totalWizards++;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setMana(int mana) {
		if (0 <= mana && mana >= 100) {
			this.mana = mana;
		}
	}
	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		}
	}
	public void setSpellPower(int spellPower) {
		if (spellPower >= 0 && spellPower <= 50) {
			this.spellPower = spellPower;
		}
	}

	public String getName() {
		return this.name;
	}
	public int getMana() {
		return this.mana;
	}
	public int getSpellPower() {
		return this.spellPower;
	}
	public int getTotalSpellPower() {
		return totalSpellPower;
	}

	public void castSpell() {
		if (mana >= 5) {
			mana -= 5;
			spellPower += 3;
			System.out.println(name + " кастует 'Lumos'");
			if (totalSpellPower + 3 >= 50) {
				System.out.println("Достигнута максимальная сила заклинаний!");
			} else {
				totalSpellPower += 3;
			}
		} else {
			System.out.println("Недостаточно маны! Попей мятный чай пожалуйста…");
		}
		System.out.println();
	}

	public void castSpell(String spellName) {
		if (mana >= 10) {
			this.mana -= 10;
			this.spellPower += 5;
			System.out.println(name + " кастует " spellName);
			if (totalSpellPower + 5 >= 50) {
				System.out.println("Достигнута максимальная сила заклинаний!");
			} else {
				totalSpellPower += 5;
			}
		} else {
			System.out.println("Недостаточно маны! Попей мятный чай пожалуйста…");
		}	
		System.out.println();
	}

	public void castSpell(String spellName, int power) {
		if (mana >= power) {
			mana -= power;
			spellPower += power;
			System.out.println(name + " кастует " spellName + " с силой " + power);
			if (totalSpellPower + power >= 50) {
				System.out.println("Достигнута максимальная сила заклинаний!");
			} else {
				totalSpellPower += power;
			}
		} else {
			System.out.println("Недостаточно маны! Попей мятный чай пожалуйста…");
		}
		System.out.println();
	}

	public void displayInfo() {
		System.out.println("=====Информация=====");
		System.out.println("Имя: " + name);
		System.out.println("Мана: " + mana);
		System.out.println("Возраст: " + age);
		System.out.println("Сила заклинаний: " + name);
		String status;
		if (mana > 50) {
			status = "готов шалить \uD83D\uDE0B";
		} else if (mana <= 50 && mana > 20) {
			status = "весёлый \uD83D\uDE09";
		} else {
			status = "уставший \uD83D\uDE29";
		}
		System.out.println("Статус: " + status);
		System.out.println();
	}

	public void rechargeMana(int amount) {
		if (mana + amount < 100) {
			mana += amount;
		} else {
			System.out.println("Мана восстановлена! Заклинания почти вызывают фейерверк!");
		}
		System.out.println();
	}

	public  static void showAcademyStats() {
		System.out.println("=====Общая информация=====");
		System.out.println("Кол-во волшебников: " + totalWizards);
		System.out.println("Суммарная сила: " + totalSpellPower);
		System.out.println();
	}
}