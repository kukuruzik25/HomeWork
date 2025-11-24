public class MainProduct {
	public static void main(String[] args) {
		Product my_product1 = new Product();
		Product my_product2 = new Product("Орешки биг боб", 350, "Скебоб");
		Product my_product3 = new Product("Дикий огурец", 10000, "Дикие", true, 1);

		my_product1.displayInfo();
		System.out.println();
		my_product2.displayInfo();
		System.out.println();
		my_product3.displayInfo();
		System.out.println();

		my_product3.inStock();
		my_product3.applyDiscount(24.0);
		my_product3.sell(1);
		my_product3.restok(5);

	}
}