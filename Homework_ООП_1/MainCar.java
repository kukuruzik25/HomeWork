public class MainCar {
	public static void main(String[] args) {
		Car my_car1 = new Car();
		Car my_car2 = new Car("Ford", "Mondeo", 2017);
		Car my_car3 = new Car("Audi", "S7 Sportback", 2021, "серый", 8800000.0, false, 52000);

		my_car1.displayInfo();
		System.out.println();
		my_car2.displayInfo();
		System.out.println();
		my_car3.displayInfo();
		System.out.println();

		my_car1.repaint("черный");
		my_car1.updatePrice(980000.0);
		my_car3.startEngine();
		my_car3.drive(52.52);
		my_car3.stopEngine();
	}
}