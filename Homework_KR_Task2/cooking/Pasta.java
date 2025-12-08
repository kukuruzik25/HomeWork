public class Pasta extends Cooking {

	private String typePasta;
	private String sauce;

	public Pasta() {
		super("Паста", 20, 2);
		this.typePasta = "свагетти";
		this.sauce = "томато";
	}

	public Pasta(String name, int time_minutes, int countPortion, String typePasta, String sauce) {
		super(name, time_minutes, countPortion);
		setTypePasta(typePasta);
		setSauce(sauce);
	}

	public void setTypePasta(String typePasta) {
		if (typePasta == null || typePasta.trim().isEmpty()) {
			System.out.println("Введите тип пасты!");
			return;
		}
		this.typePasta = typePasta;
	}
	public void setSauce(String sauce) {
		if (sauce == null || sauce.trim().isEmpty()) {
			System.out.println("Введите название соуса!");
			return;
		}
		this.sauce = sauce;
	}

	public String getTypePasta() {
		return this.typePasta;
	}
	public String getSauce() {
		return this.sauce;
	}

	@Override
	public String cooking() {
		return "1. Варим " + typePasta + "\n2.Готовим " + sauce + " соус\n3. Смешиваем пасту с соусом";
	}

	@Override
	public void info() {
        super.info();
        System.out.println("Тип пасты: " + typePasta);
        System.out.println("Соус: " + sauce);
    }

    public void addCheese() {
    	System.out.println("Добавляем сыр...");
    }

    public void addDecoration() {
    	System.out.println("Украшаем пасту...");
    }
}