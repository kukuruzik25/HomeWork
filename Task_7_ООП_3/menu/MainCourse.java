/*
● mainIngredient (String) - основной ингредиент
● sideDish (String) - гарнир
● calories (int) - калории

● getItemType() - возвращает "Основное блюдо"
● prepare() - готовит основное блюдо
● updatePrice(double newPrice) - обновить цену
● updatePrice(double newPrice, String reason) - обновить цену с указанием причины
● changeSideDish(String newSideDish) - изменить гарнир
● getCookingInstructions() - получить инструкции по приготовлению
*/
public class MainCourse extends MenuItem {

	private String mainIngredient;
	private String sideDish;
	private int calories;

	public MainCourse() {
		this.mainIngredient = "Котлетки";
		this.sideDish = "Пюрешка";
		this.calories = 150;
	}

	public MainCourse(String itemId, String name, double price) {
		super(itemId, name, price);
		this.mainIngredient = "Котлетки";
		this.sideDish = "Пюрешка";
		this.calories = 150;
	}

	public MainCourse(String itemId, String name, double price, int cookingTime, boolean isAvailable, String mainIngredient, String sideDish, int calories) {
		super(itemId, name, price, cookingTime, isAvailable);
		this.mainIngredient = mainIngredient;
		setSideDish(sideDish);
		this.calories = calories;
	}

	public void setMainIngredient() {
		this.mainIngredient = mainIngredient;
	}
	public void setSideDish() {
		this.sideDish = sideDish;
	}
	public void setCalories() {
		this.calories = calories;
	}

	public String getMainIngredient() {
		return this.mainIngredient;
	}
	public String getSideDish() {
		return this.sideDish;
	}
	public int getCalories() {
		return this.calories;
	}

	@Override
	public String getItemType() {
		return "Основное блюдо";
	}

	@Override
	public void prepare() {
		System.out.println("Приготовление основного блюда...");
		System.out.println("Приблизительное время приготовления (в мин.): " + getCookingTime());
		System.out.println("Основной ингредиент: " + mainIngredient);
		System.out.println("Гарнир: " + sideDish);
		System.out.println();
	}
	
	public void updatePrice(double newPrice) {
		setPrice(newPrice);
		System.out.println("Цена обновлена: " + getPrice());
	}

	public void updatePrice(double newPrice, String reason) {
		setPrice(newPrice);
		System.out.println("Цена обновлена: " + getPrice() + ", по причине: " + reason);
	}

	public void changeSideDish(String newSideDish) {
		this.sideDish = newSideDish;
		System.out.println("Гарнир изменен на ---> " + sideDish);
	}

	public void getCookingInstructions() {
		System.out.println("=====Инструкция приготовления=====");
		System.out.println("1. Приготовить основной ингредиент: " + mainIngredient);
		System.out.println("2. Приготовить гарнир: " + sideDish);
		System.out.println("Вы великолепны!");
		System.out.println("Общее время приготовления (в мин.) ---> " + getCookingTime());
		
	}
}