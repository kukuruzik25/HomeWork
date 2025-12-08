public class Soup extends Cooking {

	private String typeBroth;
	private boolean puree;

	public Soup() {
		super("Суп", 30, 5);
		this.typeBroth = "куриный";
		this.puree = false;
	}

	public Soup(String name, int time_minutes, int countPortion, String typeBroth, boolean puree) {
		super(name, time_minutes, countPortion);
		setTypeBroth(typeBroth);
		setPuree(puree);
	}
	
	public void setTypeBroth(String typeBroth) {
		if (typeBroth == null || typeBroth.trim().isEmpty()) {
			System.out.println("Введите тип бульона!");
			return;
		}
		this.typeBroth = typeBroth;
	}
	public void setPuree(boolean puree) {
		this.puree = puree;
	}

	public String getTypeBroth() {
		return this.typeBroth;
	}
	public boolean getPuree() {
		return this.puree;
	}

	@Override
	public String cooking() {
		return "1. Готовим " + typeBroth + " бульон\n2. Добавляем овощи и мясо\n3. Варим пока не сварим" + (puree ? "\n4. Пюрируем суп" : "");
	}

	@Override
	public void info() {
		super.info();
		System.out.println("Тип бульона: " + typeBroth);
        System.out.println("Суп-пюре: " + puree);
	}

	public void addGreens() {
		System.out.println("Добавляем зелень...");
	}

	public void makePuree() {
		System.out.println("Делаем суп-пюре...");
		this.puree = true;
	}
}
