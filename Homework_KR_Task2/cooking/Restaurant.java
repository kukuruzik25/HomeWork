public class Restaurant {

	private String name;

	public Restaurant() {
		this("Ресторан");
	}

	public Restaurant(String name) {
		setName(name);
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			System.out.println("Введите имя!");
			return;
		}
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void open() {
        System.out.println("Ресторан " + name + " открылся...");
    }

    public void close() {
        System.out.println("Ресторан " + name + " закрылся...");
    }
    
    public void serveFood(Cooking dish) {
        System.out.println("Подаем блюдо: " + dish.getName());
        dish.info();
    }
}