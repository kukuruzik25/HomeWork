/*
● String house — факультет
● int mischiefLevel — уровень шалостей (0–100)

● Метод void prank() — увеличивает mischiefLevel, уменьшает mana
*/
public class HogwartsStudent extends Wizard {

	private String house;
	private int mischiefLevel;

	public HogwartsStudent() {
		this.house = "Гриффиндор";
		this.mischiefLevel = 0;
	}

	public HogwartsStudent(String name, int mana, int age, int spellPower, String house, int mischiefLevel) {
		super(name, mana, age, spellPower);
		this.house = house;
		this.mischiefLevel = mischiefLevel;
	}

	public void setHouse(String house) {
		this.house = house;
	}
	public void setMischiefLevel(int mischiefLevel) {
		if (mischiefLevel >= 0 && mischiefLevel <= 100) {
			this.mischiefLevel = mischiefLevel;
		}
	}

	public String getHouse() {
		return this.house;
	}
	public int getMischiefLevel() {
		return mischiefLevel;
	}

	public void prank() {
		if (mana >= 2) {
			mischiefLevel += 5;
			mana -= 2;
			System.out.println("Гарри подложил слизеринскому студенту лягушку в учебник!");
		} else {
			System.out.println("Недостаточно маны! Попей мятный чай пожалуйста…");
		}
	}
}