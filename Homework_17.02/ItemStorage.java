public class ItemStorage<T> {
	private T value;

	public ItemStorage(T value) {
		this.value = value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void compareWith(T otherValue) {
		if (value == null || otherValue == null) {
			System.out.println("Опачки! Ревизия невозможна, объект не найден");
		} else if (value == otherValue) {
			System.out.println("Значения идентичны. Контроль качества пройден");
		}
	}
}