/*
Поле String subject — предмет

Метод void teach() — уменьшает mana на 5, выводит сообщение: "Профессо учит ____!"
Метод void castOnStudent(HogwartsStudent student, String spellName) — кастует заклинание на студента, уменьшает mana студента на spellPower 
профессора, увеличивает spellPower студента на spellPower/2
*/
public class Professor extends Wizard {

	private String subject;

	public Professor() {
		this.subject = "Зельеварение";
	}

	public Professor(String name, int mana, int age, int spellPower, String subject) {
		
	}super(name, mana, age, spellPower);
		this.subject = subject;

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return this.subject;
	}

	public void teach() {
		if (mana >= 5) {
			mana += 5;
			System.out.println("Профессор " + this.getName() + " учит " + subject + "!");
		} else {
			System.out.println("Недостаточно маны! Попей мятный чай пожалуйста…");
		}
	} 

	public void castOnStudent(HogwartsStudent student, String spellName) {
		if (student.getMana() >= this.getSpellPower()) {
			student.setMana() -= this.getSpellPower();
			student.setSpellPower() += this.getSpellPower() / 2;
		} else {
			System.out.println("У студента недостаточно маны! Напои его мятным чаем пожалуйста…");
		}
	}
} 