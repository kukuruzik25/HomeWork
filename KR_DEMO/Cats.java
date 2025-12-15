public class Cats {
	
	private String name;
	private String color;
	private boolean isSolitaryLifestyle;

	public Cats(String name, String color, boolean isSolitaryLifestyle) {
		setName(name);
		setColor(color);
		setIsSolitaryLifestyle(isSolitaryLifestyle);
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			System.out.println("Введите имя!");
			return;
		}
		this.name = name;
	}
	public void setColor() {
		if (color == null || color.trim().isEmpty()) {
			System.out.println("Введите окрас!");
			return;
		}
		this.color = color;
	}
	public void setIsSolitaryLifestyle(boolean isSolitaryLifestyle) {
		this.isSolitaryLifestyle = isSolitaryLifestyle;
	}

	public String getName() {
		return this.name;
	}
	public String getColor() {
		return this.color;
	}
	public boolean getIsSolitaryLifestyle() {
		return this.isSolitaryLifestyle;
	}

	public String makeSound() {
		return "*что-то мяукает*";
	}

	public void hunting(String beast) {
		System.out.println("*охотится на " + animal + "*");
	}
}