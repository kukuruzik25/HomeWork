/*
● itemId (String) - уникальный идентификатор блюда
● name (String) - название блюда
● price (double) - цена
● cookingTime (int) - время приготовления в минутах
● isAvailable (boolean) - доступно ли для заказа

● getItemType() - возвращает тип блюда (базовая реализация)
● prepare() - приготовить блюдо (базовая реализация)
● displayInfo() - показать информацию о блюде
● updatePrice(double newPrice) - обновить цену
*/
public abstract class MenuItem {

	public static final int MAX_COOKING_TIME = 120;
	private static int totalMenuItems = 0;
	
	private String itemId;
	private String name;
	private double price;
	private int cookingTime;
	private boolean isAvailable;

	public MenuItem() {
		this("0000", "Блюдо", 0.0, 0, false);
	}

	public MenuItem(String itemId, String name, double price) {
		this(itemId, name, price, 10, false);
	}

	public MenuItem(String itemId, String name, double price, int cookingTime, boolean isAvailable) {
		setItemId(itemId);
		this.name = name;
		setPrice(price);
		setCookingTime(cookingTime);
		this.isAvailable = isAvailable;
		totalMenuItems++;
	}

	public void setItemId(String itemId) {
		if (itemId == null || itemId.trim.isEmpty()) {
			System.out.println("ID не может быть пустым!");
			return;
		}
		this.itemId = itemId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		if (price >= 0) {
			this.price = price;
		} else {
			System.out.println("Цена не может быть отрицательной!");
		}
	}
	public void setCookingTime(int cookingTime) {
		if (1 <= cookingTime && cookingTime <= MAX_COOKING_TIME) {
			this.cookingTime = cookingTime;
		} else {
			System.out.println("Время приготовления должно быть от 0 до 120 минут!");
		}
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getItemId() {
		return this.itemId;
	}
	public String getName() {
		return this.name;
	} 
	public double getPrice() {
		return this.price;
	}
	public int getCookingTime() {
		return this.cookingTime;
	}
	public boolean getIsAvailable() {
		return this.isAvailable;
	}
	public static int getTotalMenuItems() {
		return totalMenuItems;
	}

	public abstract String getItemType();
	public abstract void prepare();

	public void displayInfo() { 
		System.out.println("=====Информация о " + name + "=====");
		System.out.println("Тип: " + getItemType());
		System.out.println("Цена(в руб.): " + price);
		System.out.println("Время приготовления(в мин.): " + cookingTime);
		System.out.println();	
	}

	public void updatePrice(double newPrice) {
		this.price = newPrice;
		System.out.println("Новая цена(в руб.): " + price);
	}
}