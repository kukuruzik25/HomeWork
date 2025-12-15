/*
● servingTemperature (String) - температура подачи (холодная/горячая)
● isVegetarian (boolean) - вегетарианское ли
● spiceLevel (int) - уровень остроты (1-5)

● getItemType() - возвращает "Закуска"
● prepare() - готовит закуску
● displayInfo() - базовая информация
● displayInfo(boolean showDetails) - подробная информация с деталями
● changeSpiceLevel(int level) - изменить уровень остроты
● getNutritionInfo() - получить информацию о питательности
*/
public class Appetizer extends MenuItem {

	private String servingTemperature;
	private boolean isVegetarian;
	private int spiceLevel;

	public Appetizer() {
		this.servingTemperature = "Холодная";
		this.isVegetarian = true;
		this.spiceLevel = 1;
	}

	public Appetizer(String itemId, String name, double price) {
		super(itemId, name, price);
		this.servingTemperature = "Холодная";
		this.isVegetarian = true;
		this.spiceLevel = 1;
	}

	public Appetizer(String itemId, String name, double price, int cookingTime, boolean isAvailable, String servingTemperature, boolean isVegetarian, int spiceLevel) {
		super(itemId, name, price, cookingTime, isAvailable);
		this.servingTemperature = servingTemperature;
		this.isVegetarian = isVegetarian;
		setSpiceLevel(spiceLevel);
	}

	public void setServingTemperature(String servingTemperature) {
		this.servingTemperature = servingTemperature;
	}
	public void setIsVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}
	public void setSpiceLevel(int spiceLevel) {
		if (spiceLevel >= 1 && spiceLevel <=5) {
			this.spiceLevel = spiceLevel;
		} else {
			System.out.println("Введите уровень от 1 до 5!");
		}
	}

	public String getServingTemperature() {
		return this.servingTemperature;
	}
	public boolean getIsVegetarian() {
		return this.isVegetarian;
	}
	public int getSpiceLevel() {
		return this.spiceLevel;
	}

	@Override
	public String getItemType() {
		return "Закуска";
	}

	@Override
	public void prepare() {
		System.out.println("Приготовление закуски...");
		System.out.println("Приблизительное время приготовления: " + getCookingTime());
		System.out.println("Температура подачи: " + servingTemperature);
		System.out.println("Уровень остроты: " + spiceLevel);
		System.out.println();
	}

	public void displayInfo() {
		System.out.println("=====Информация о " + getName() + "=====");
		System.out.println("Тип: " + getItemType());
		System.out.println("Цена(в руб.): " + getPrice());
		System.out.println("Время приготовления(в мин.): " + getCookingTime());
		System.out.println();
	}

	public void displayInfo(boolean showDetails) {
		if (showDetails) {
			System.out.println("=====Подробная информация о " + name + "=====");
			System.out.println("Тип: " + getItemType());
			System.out.println("Цена(в руб.): " + getPrice());
			System.out.println("Время приготовления(в мин.): " + getCookingTime());
			System.out.println("Уровень остроты: " + spiceLevel);
			System.out.println("Подходит для вегетерианцев: " + (isVegetarian ? "Да" : "Нет"));
			System.out.println("Доступно для заказа: " + (getIsAvailable() ? "Да" : "Нет"));
			System.out.println();
		} else {
			displayInfo();
		}
	}

	public void changeSpiceLevel(int level) {
		if (level >= 1 && level <=5) {
			this.spiceLevel = level;
		} else {
			System.out.println("Введите уровень от 1 до 5!");
		}
	}

	public void getNutritionInfo() {
		System.out.println("=====Питательность " + getName() + "=====");
		System.out.println("Подходит для вегетерианцев: " + (isVegetarian ? "Да" : "Нет"));
		System.out.println("Уровень остроты: " + spiceLevel);
		int calories = 150 * (getCookingTime()/10);
		System.out.println("Калорийность: " + calories);
		System.out.println();
	}
}