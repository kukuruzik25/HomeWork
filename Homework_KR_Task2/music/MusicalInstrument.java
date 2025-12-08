public abstract class MusicalInstrument {

	private String name;
	private String type_instrument;

	public MusicalInstrument() {
		this("балалайка", "струнный");
	}

	public MusicalInstrument(String name, String type_instrument) {
		setName(name);
		setTypeInstrument(type_instrument);
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			System.out.println("Введите название!");
			return;
		}
		this.name = name;
	}
	public void setTypeInstrument(String type_instrument) {
		if (type_instrument == null || type_instrument.trim().isEmpty()) {
			System.out.println("Введите тип инструмента!");
			return;
		}
		this.type_instrument = type_instrument;
	}

	public String getName() {
		return this.name;
	}
	public String getTypeInstrument() {
		return this.type_instrument;
	}

	public abstract play();

	public void tune() {
        System.out.println(name + " настраивается...");
    }

	public void displayInfo() {
        System.out.println("=== Информация об инструменте ===");
        System.out.println("Название: " + name);
        System.out.println("Бренд: " + brand);
        System.out.println("Цена: " + price + " руб.");
    }
}