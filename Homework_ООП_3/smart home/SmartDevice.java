/* 
● deviceId (String) - уникальный идентификатор устройства
● deviceName (String) - название устройства
● location (String) - местоположение в доме
● isPoweredOn (boolean) - статус включения устройства
● powerConsumption (double) - потребление энергии в ваттах

● getDeviceType() - возвращает тип устройства (базовая реализация)
● performAction() - выполнить действие устройства (базовая реализация)
● turnOn() - включить устройство
● turnOff() - выключить устройство
● getStatus() - получить статус устройства
*/

public abstract class SmartDevice {

	private static int totalDevices = 0;
	public static final double MAX_POWER_CONSUMPTION = 5000.0;

	private String deviceId;
	private String deviceName;
	private String location;
	private boolean isPoweredOn;
	private double powerConsumption;

	public SmartDevice() {
		this("0000", "Defolt", "Home", false, 0.0);
	}

	public SmartDevice(String deviceId, String deviceName, String location) {
		this(deviceId, deviceName, location, false, 0.0);
	}

	public SmartDevice(String deviceId, String deviceName, String location, boolean isPoweredOn, double powerConsumption) {
		setDeviceId(deviceId);
		this.deviceName = deviceName;
		this.location = location;
		this.isPoweredOn = isPoweredOn;
		setPowerConsumption(powerConsumption);
		totalDevices++;
	}

	public void setDeviceId(String deviceId) {
		if (deviceId == null || deviceId.trim().isEmpty())  {
			System.out.println("ID не может быть пустым!");
			return;
		}
		this.deviceId = deviceId;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setIsPoweredOn(boolean isPoweredOn) {
		this.isPoweredOn = isPoweredOn;
	}
	public void setPowerConsumption(double powerConsumption) {
		if (powerConsumption < 0 || powerConsumption > MAX_POWER_CONSUMPTION) {
			System.out.println("Потребление энергии (в Вт) не может быть меньше нуля или превышать максимальное значение!");
			return;
		}
		this.powerConsumption = powerConsumption;
	}

	public static int getTotalDevices() {
		return totalDevices;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public String getLocation() {
		return location;
	}
	public boolean getIsPoweredOn() {
		return isPoweredOn;
	}
	public double getPowerConsumption() {
		return powerConsumption;
	}

	public abstract String getDeviceType();
	public abstract void performAction();
	
	public void turnOn() {
		isPoweredOn = true;
		System.out.println("Устройство " + deviceName + " включено...");
	}

	public void turnOff() {
		isPoweredOn = false;
		System.out.println("Устройство " + deviceName + " выключено...");
	} 

	public String getStatus() {
		String status = (getIsPoweredOn()) ? "Включено" : "Выключено";
		return "=====Статус=====" + "\nУстройство " + getDeviceName() + "\nВкл./Выкл.: " + status + "\nПотребление (в Вт): " + powerConsumption;
	}
}