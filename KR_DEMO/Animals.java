public abstract class Animals {

	private String name;
	private String type;
	private int age;

	public Animals(String name, String type, int age) {
		setName(name);
		setType(type);
		setAge(age);
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			System.out.println("Введите имя животного!");
			return;
		}
		this.name = name;
	}
	public void setType(String type) {
		if (type == null || type.trim().isEmpty()) {
			System.out.println("Введите вид животного!");
			return;
		}
		this.type = type;
	}
	public void setAge(int age) {
		if (age < 0) {
			System.out.println("Возраст не может быть отрицательным!");
			return;
		}
		this.age = age;
	}

	public String getName() {
		return this.name;
	}
	public String getType() {
		return this.type;
	}
	public int getAge() {
		return this.age;
	}

	public abstract String makeSound();

	public void eat() {
		System.out.println(this.getName() + " кушает...");
	} 
}