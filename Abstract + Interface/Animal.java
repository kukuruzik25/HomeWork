public abstract class Animal {

	private String name;
	private int age;

	public Animal() {
		this("Бобик", 12);
	}

	public Animal(String name, int age) {
		setName(name);
		this.age = age;
	}

	public void setName() {
		this.name = name;
	}
	public void setAge(int age) {
        this.age = age;
    }

	public String getName() {
		return name;
	}
	public int getAge() {
        return age;
    }

    public abstract void makeSound();

	public void eat() {
		System.out.println(name + " кушает...");
	}

	public void sleep() {
		System.out.println(name + " спит...");
	}

	public String displayInfo() {
        return "Имя: " + name + ", Возраст: " + age;
    }
}