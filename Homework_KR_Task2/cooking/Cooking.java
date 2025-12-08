public abstract class Cooking  {

	private String name;
	private int time_minutes;
	private int countPortion;

	public Cooking() {
		this("Шедевр", 10, 1);
	}

	public Cooking(String name, int time_minutes, int countPortion) {
		setName(name);
		setTimeMinutes(time_minutes);
		setCountPortion(countPortion);
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			System.out.println("Введите название!");
			return;
		}
		this.name = name;
	}
	public void setTimeMinutes(int time_minutes) {
		if (time_minutes <= 0) {
			System.out.println("Время должно быть больше 0!");
		}
		this.time_minutes = time_minutes;
	}
	public void setCountPortion(int countPortion) {
		if (countPortion <= 0) {
			System.out.println("Порций должно быть больше 0!");
		}
		this.countPortion = countPortion;
	}

	public String getName() {
		return this.name;
	}
	public int getTimeMinutes() {
		return this.time_minutes;
	}
	public int getCountPortion() {
		return this.countPortion;
	}

	public abstract String cooking();

	public int allTimeSeconds() {
		return this.time_minutes * this.countPortion;
	}

	public void info() {
		System.out.println("=====Инфо=====");
		System.out.println("Название: " + name);
		System.out.println("Время приготовления: " + time_minutes);
		System.out.println();
	}	
}