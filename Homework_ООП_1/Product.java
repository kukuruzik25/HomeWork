public class Product {

	private String name;
	private double price;
	private String category;
	private boolean inStock;
	private int quantity;

	public Product() {
		this("Форель", 600, "Рыба и морепродукты", true, 15);
	}

	public Product(String name, double price, String category) {
		this(name, price, category, false, 0);
	}

	public Product(String name, double price, String category, boolean inStock, int quantity) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.inStock = inStock;
		this.quantity = quantity;
	}

	public void displayInfo() {
		System.out.println("Название: " + name + "\nЦена: " + price + "\nКатегория: " + category + "\nНаличие: " + inStock + "\nКол-во(в наличии): " + quantity);
	}

	public void applyDiscount(double percent) {
		double discount = price * (percent / 100);
		this.price -= discount;
		System.out.println("Скидка составила " + discount + " берёзовых листочка\n" + "Новая цена: " + price);
	} 
		
	public void inStock() {
		if (quantity > 0) {
			this.inStock = true;
			System.out.println("Есть в наличии");
		} else {
			System.out.println("Нет в наличии");
		}
		
	}

	public void restok(int amount) {
		quantity += amount;
		System.out.println("Наличие пополнено, на складе: " + quantity);
	}

	public void sell(int amount) {
		if (amount > quantity) {
			this.quantity = 0;
			System.out.println("Закончился на складе");
		} else {
			this.quantity -= amount;
			System.out.println("Продано товара: " + amount + "\nОстаток на складе: " + quantity);
		}
	}
}