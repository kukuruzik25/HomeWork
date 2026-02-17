public class Main {
	public static void main(String[] args) {

		ItemStorage<Integer> item1 = new ItemStorage<>(100);
		item1.compareWith(100);
		// по идее true, тк мы сравниваем объекты
		ItemStorage<Integer> item2 = new ItemStorage<>(200);
		item2.compareWith(200);
		// по идее false, тк мы сравниваем ссылки
		Fraction drob1 = new Fraction(1,2);
		Fraction drob2 = new Fraction(1,2);
		ItemStorage<Fraction> item3 = new ItemStorage<>(drob2);
		item3.compareWith(drob1);
		// вот тут чуток не пон

		/*
		но у меня что-то чуток не работает, 
		из-за того, что я немного не пон,
		как переопределять hash-код в Fraction
		*/
	}
}