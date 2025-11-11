public class Car {

	private String brand;
	private String model;
	private int year;
	private String color;
	private double price;
	private boolean isRunning;
	private double mileage;

	public Car() {
		this("Volkswagen", "Jetta", 2017, "белый", 900000.0, false, 135000);
	}

	public Car(String brand, String model, int year) {
		this(brand, model, year, "белый", 1060000.0, true, 110000);
	}

	public Car(String brand, String model, int year, String color, double price, boolean isRunning, double mileage) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.color = color;
		this.price = price;
		this.isRunning = isRunning;
		this.mileage = mileage;
	}

	public void displayInfo() {
		System.out.println("Марка: " + brand + "\nМодель: " + model + "\nГод выпуска: " + year + "\nЦвет: " + color + "\nЦена: " + price + "\nДвигатель заведен: " + isRunning + "\nПробег: " + mileage);
	}

	public void startEngine() {
		this.isRunning = true;
		System.out.println("Двигатель заведен...");
	}

	public void stopEngine() {
		this.isRunning = false;
		System.out.println("Двигатель заглушен.");
	}

	public void drive(double distance) {
		if (isRunning) {
			this.mileage += distance;
			System.out.println("Пройдено " + distance + " км");
		}
	}

	public void repaint(String newColor) {
		String oldColor = color;
		this.color = newColor;
		System.out.println("Машина перекрашена: " + oldColor + " ---> " + color);
	}

	public void updatePrice(double newPrice) {
		double oldPrice = price;
		this.price = newPrice;
		System.out.println("Цена машины изменена: " + oldPrice + " ---> " + price);
	}
}