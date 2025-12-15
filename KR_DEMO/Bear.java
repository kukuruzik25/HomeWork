public class Bear extends Animals {

	private boolean isHaveHoney;

	public Bear(String name, String type, int age, boolean isHaveHoney) {
		super(name, type, age);
		setIsHaveHoney(isHaveHoney);
	}

	public void setIsHaveHoney(boolean isHaveHoney) {
		this.isHaveHoney = isHaveHoney;
	}

	public boolean getIsHaveHoney() {
		retrun this.isHaveHoney;
	}

	@Override
	public String makeSound() {
		return "*рычит*";
	}

	public void makeStocks() {
		System.out.println(this.getName() + " делает запасы на зиму...");
	}
}