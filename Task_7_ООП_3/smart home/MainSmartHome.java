public class MainSmartHome {
	public static void main(String[] args) {
		SmartHome my_home = new SmartHome("Хибара");

		SmartLight lamp = new SmartLight("lamp1", "Лампа на кухне", "Кухная");
		SmartThermostat termostat = new SmartThermostat("termostat1", "Термостат в спальне", "Спальня");
		SmartSecurityCamera camera = new SmartSecurityCamera("camera1", "Камера во дворе", "Двор");

		my_home.addDevice(lamp);
		my_home.addDevice(termostat);
		my_home.addDevice(camera);
		System.out.println();

		my_home.turnOnAllDevices();
		System.out.println();

		lamp.setBrightness(75);
		lamp.dimLights();
		lamp.performAction();
		System.out.println();

		termostat.setTemperature(24.5);
		termostat.setTemperature(20.0, "Охлаждение");
		termostat.getEnergyReport();
		termostat.performAction();
		System.out.println();

		camera.startRecording(true); 
		camera.getLiveFeed();
		camera.performAction();
		System.out.println();

		my_home.getDevicesByType("Умная камера");
		my_home.calculateTotalPowerConsumption();
		my_home.getDeviceStatus("lamp1");
		System.out.println();

		my_home.turnOffAllDevices();
		System.out.println();

		System.out.println("Всего устройств в доме: " + my_home.getDeviceCount());
		System.out.println("Всего устройств: " + SmartDevice.getTotalDevices());
	}
}