/*
● currentTemperature (double) - текущая температура
● targetTemperature (double) - целевая температура
● mode (String) - режим (охлаждение/обогрев)

● getDeviceType() - возвращает "Умный термостат"
● performAction() - регулирует температуру
● setTemperature(double temp) - установить температуру
● setTemperature(double temp, String mode) - установить температуру и режим
● getEnergyReport() - получить отчет по энергии
● scheduleTemperature(double temp, int hour) - запланировать температуру
*/
public class SmartThermostat extends SmartDevice {
	
	private double currentTemperature;
	private double targetTemperature;
	private String mode;

	public SmartThermostat() {
		this.currentTemperature = 18.0;
		this.targetTemperature = 22.0;
		this.mode = "Обогрев";
	}

	public SmartThermostat(String deviceId, String deviceName, String location) {
		super(deviceId, deviceName, location);
		this.currentTemperature = 18.0;
		this.targetTemperature = 22.0;
		this.mode = "Обогрев";
	}

	public SmartThermostat(String deviceId, String deviceName, String location, boolean isPoweredOn, double powerConsumption, double currentTemperature, double targetTemperature, String mode) {
		super(deviceId, deviceName, location, isPoweredOn, powerConsumption);
		this.currentTemperature = currentTemperature;
		this.targetTemperature = targetTemperature;
		this.mode = mode;
	}

	public void setCurrentTemperature(double currentTemperature) {
		this.currentTemperature = currentTemperature;
	}
	public void setTargetTemperature(double targetTemperature) {
		this.targetTemperature = targetTemperature;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}

	public double getCurrentTemperature() {
		return this.currentTemperature;
	}
	public double getTargetTemperature() {
		return this.targetTemperature;
	}
	public String getMode() {
		return this.mode;
	}

	@Override
	public String getDeviceType() {
		return "Умный термостат";
	}

	@Override
	public void performAction() {
		String action = (!getIsPoweredOn()) ? " выключен" :
						(currentTemperature > targetTemperature) ? " охлаждает" : " нагревает";
		System.out.println(getDeviceName() + action + ", температура: " + currentTemperature + " ---> " + targetTemperature);
	}

	public void setTemperature(double temp) {
		this.targetTemperature = temp;
		System.out.println("Установлена целевая температура ---> " + targetTemperature);
	}
	public void setTemperature(double temp, String mode) {
		this.targetTemperature = temp;
		this.mode = mode;
		System.out.println("Установлена целевая температура ---> " + targetTemperature + " и изменен режим ---> " + mode);
	}

	public void getEnergyReport() {
		System.out.println("=====Отчет(по энергии)=====" + "\nНазвание устройства: " + getDeviceName() + "\nПотребление энергии (в Вт): " + getPowerConsumption());
	}

	public void scheduleTemperature(double temp, int hour) {
		this.targetTemperature = temp;
		System.out.println("Температура " + targetTemperature + " запланирована через " + hour + " часов");
	}
}