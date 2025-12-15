public class MainMobilePhone {
	public static void main(String[] args) {
		MobilePhone my_phone1 = new MobilePhone();
		MobilePhone my_phone2 = new MobilePhone("Iphone", "17 Pro Max", 2000);
		MobilePhone my_phone3 = new MobilePhone("Samsung", "Galaxy S25", 256, 0, true);

		my_phone1.displayInfo();
		System.out.println();
		my_phone2.displayInfo();
		System.out.println();
		my_phone3.displayInfo();
		System.out.println();

		my_phone2.powerOn();
		my_phone2.useBattery(32);
		my_phone2.powerOff();
		my_phone2.chargeBattery(45);
	}
}		