public class MobilePhone {

	private String brand;
	private String model;
	private int storageGB;
	private int batteryLevel;
	private boolean isPoweredOn;

	public MobilePhone() {
		this("Alcatel", "OneTouch Idol Mini", 4, 100, true);
	}

	public MobilePhone(String brand, String model, int storageGB) {
		this(brand, model, storageGB, 100, false);
	}

	public MobilePhone(String brand, String model, int storageGB, int batteryLevel, boolean isPoweredOn) {
		this.brand = brand;
		this.model = model;
		this.storageGB = storageGB;
		this.batteryLevel = batteryLevel;
		this.isPoweredOn = isPoweredOn;
	}

	public void displayInfo() {
		System.out.println("Brand: " + brand + "\nModel: " + model + "\nStorage(GB): " + storageGB + "\nBattery level: " + batteryLevel + "\nPowered on: " + isPoweredOn);
	}

	public void powerOn() {
		this.isPoweredOn = true;
		System.out.println("Powered on: " + isPoweredOn);
	}

	public void powerOff() {
		this.isPoweredOn = false;
		System.out.println("Powered on: " + isPoweredOn);
	}

	public void chargeBattery(int precent) {
		if (!isPoweredOn) {
			isPoweredOn = true;
		}
		int newCharge = precent + batteryLevel;
		if (newCharge >= 100) {
			batteryLevel = 100;
			System.out.println("Battery is charged: " + batteryLevel + "% and Phone is ON");
		} else {
			batteryLevel = newCharge;
			System.out.println("Battery is charged: " + batteryLevel + "% and Phone is ON");
		}	
	}

	public void useBattery(int precent) {
		int newCharge = batteryLevel - precent;
		if (newCharge <= 0) {
			batteryLevel = 0;
			isPoweredOn = false;
			System.out.println("Battery is low: " + batteryLevel + "%");
		} else {
			batteryLevel = newCharge;
			System.out.println("Battery is low: " + batteryLevel + "%");
		}
	}

}
