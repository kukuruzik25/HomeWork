/*
Поле String creatureType — тип существа (Elf, Centaur…)

Метод void specialAbility(Wizard target) — уменьшает mana цели на
spellPower существа, увеличивает spellPower на spellPower/2

Перегруженный метод void specialAbility() — демонстрирует способность
без цели, выводит смешное сообщение
*/
public class MagicalCreature extends Wizard {

	private String creatureType;

	public MagicalCreature() {
		this("Чупакабра");
	}

	public MagicalCreature(String name, int mana, int age, int spellPower, String creatureType) {
		super(name, mana, age, spellPower);
		setCreatureType(creatureType);
	}

	public setCreatureType(String creatureType) {
		this.creatureType = creatureType;
	}

	public String getCreatureType() {
		return this.creatureType;
	}

	public void specialAbility(Wizard target) {
		target.setMana(target.getMana() - getMana());
		setSpellPower(getSpellPower() + target.getSpellPower() / 2);
        System.out.println(name + " обрушивает на " + target +  " лютое заклинание");
	}

	public void specialAbility() {
		System.out.println("Люто колдует...");
	}
}