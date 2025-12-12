/*
● sweetnessLevel (int) - уровень сладости (1-10)
● containsNuts (boolean) - содержит ли орехи
● isGlutenFree (boolean) - без глютена

● getItemType() - возвращает "Десерт"
● prepare() - готовит десерт
● prepare() - обычное приготовление
● prepare(boolean withExtraDecoration) - приготовление с дополнительным украшением
● addTopping(String topping) - добавить топпинг
● checkAllergies() - проверить наличие аллергенов
*/
public class Dessert extends MenuItem {
	
	private int sweetnessLevel;
	private boolean containsNuts;
	private boolean isGlutenFree;

	public Dessert() {
		this.sweetnessLevel = 5;
		this.containsNuts = true;
		this.isGlutenFree = false;
	}

	public Dessert(String itemId, String name, double price) {
		super(itemId, name, price);
		this.sweetnessLevel = 5;
		this.containsNuts = true;
		this.isGlutenFree = false;
	}

	public Dessert(String itemId, String name, double price, int cookingTime, boolean isAvailable, int sweetnessLevel, boolean containsNuts, boolean isGlutenFree) {
		super(itemId, name, price, cookingTime, isAvailable);
		this.sweetnessLevel = sweetnessLevel;
		this.containsNuts = containsNuts;
		this.isGlutenFree = isGlutenFree;
	}

	public void setSweetnessLevel(int sweetnessLevel) {
		if (sweetnessLevel >= 1 && sweetnessLevel <= 10) {
			this.sweetnessLevel = sweetnessLevel;
		} else {
			System.out.println("Уровень сладости должен быть от 1 до 10!");
		}
	}
	public void setContainsNuts(boolean containsNuts) {
		this.containsNuts = containsNuts;
	}
	public void setIsGlutenFree(boolean isGlutenFree) {
		this.isGlutenFree = isGlutenFree;
	}

	public int getSweetnessLevel() {
		return this.sweetnessLevel;
	}
	public boolean getContainsNuts() {
		return this.containsNuts;
	}
	public boolean getIsGlutenFree() {
		return this.isGlutenFree;
	} 

	@Override
	public String getItemType() {
		return "Десерт";
	}

	@Override
	public void prepare() {
		System.out.println("Приготовление десерта '" + getName() + "'...");
		System.out.println("Приблизительное время приготовления (в мин.): " + getCookingTime());
		System.out.println("Уровень сладости: " + sweetnessLevel);
		System.out.println("Содержание орехов: " + (sideDish ? "Да" : "Нет"));
		System.out.println();
	}

	public void prepare(boolean withExtraDecoration) {
		if (withExtraDecoration) {
			System.out.println("Приготовление десерта '" + getName() + "' с украшением...");
			System.out.println("Приблизительное время приготовления (в мин.): " + getCookingTime());
			System.out.println("Уровень сладости: " + sweetnessLevel);
			System.out.println("Содержание орехов: " + (sideDish ? "Да" : "Нет"));
			int newPrice = getPrice() + 50;
			setPrice(newPrice);
			System.out.println("+ 50 к цене ---> " + getPrice());
			System.out.println();
		} else {
			prepare();
		}
		
	}

	public void addTopping(String topping) {
		System.out.println("К десерту '" + getName() + "' добавлен топпинг: " + topping);
		int newPrice = getPrice() + 50;
		setPrice(newPrice);
		System.out.println("Новая цена ---> " + getPrice());
	}

	public void checkAllergies() {
		if (isGlutenFree && !containsNuts) {
			System.out.println("Не содержит аллергенов");
		} else {
			System.out.println("Содержит аллергены!");
		}
	}
}