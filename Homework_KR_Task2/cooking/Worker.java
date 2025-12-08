public class Worker {

	private String name;

	public Worker() {
		this("Вадик");
	}

	public Worker(String name) {
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

	public void work() {
		System.out.println(name + " работает...");
	}

	public void takeBreak() {
		System.out.println(name + " на перекуре...");
	}
}