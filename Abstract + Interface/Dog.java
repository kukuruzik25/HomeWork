public class Dog extends Animal implements Runnable {

	public Dog() {
		super();
	}

	public Dog(String name, int age) {
		super(name, age);
	}

	@Override
	public void makeSound() {
		System.out.println("Гав!");
	}

	@Override
	public void run() {
		return "Собачка бежит";
	}
}