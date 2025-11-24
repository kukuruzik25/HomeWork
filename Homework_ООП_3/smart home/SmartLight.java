/*
● brightness (int) - яркость (0-100%)
● color (String) - цвет света
● isColorChanging (boolean) - поддерживает ли смену цвета

● getDeviceType() - возвращает "Умная лампа"
● performAction() - включает/выключает свет
● setBrightness(int level) - установить яркость
● setBrightness(int level, String color) - установить яркость и цвет
● changeColor(String newColor) - изменить цвет
● dimLights() - приглушить свет
*/
public class SmartLight extends SmartDevice {
	
	private int brightness;
	private String color;
	private boolean isColorChanging;

	public SmartLight() {
		this.brightness = 100;
		this.color = "Белый";
		this.isColorChanging = false;
	}

	public SmartLight(String deviceId, String deviceName, String location) {
		super(deviceId, deviceName, location);
		this.brightness = 100;
		this.color = "Белый";
		this.isColorChanging = false;
	}

	public SmartLight(String deviceId, String deviceName, String location, boolean isPoweredOn, double powerConsumption, int brightness, String color, boolean isColorChanging) {
		super(deviceId, deviceName, location, isPoweredOn, powerConsumption);
		this.brightness = brightness;
		this.color = color;
		this.isColorChanging = isColorChanging;
	}

	public void setBrightness(int level) {
		if (level < 0 || level > 100) {
			System.out.println("Введите значения яркости от 0 до 100!");
			return;
		}
		this.brightness = level;
	}
	public void setBrightness(int level, String color) {
		setBrightness(level);
		setColor(color);
		System.out.println("Установлена яркость " + level + "% и " + color + " цвет");
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setIsColorChanging(boolean isColorChanging) {
		this.isColorChanging = isColorChanging;
	}

	public int getBrightness() {
		return this.brightness;
	}
	public String getColor() {
		return this.color;
	}
	public boolean getIsColorChanging() {
		return this.isColorChanging;
	}

	@Override
	public String getDeviceType() {
		return "Умная лампа"; 
	}

	@Override
	public void performAction() {
		String action = (getIsPoweredOn()) ? " светит с яркостью " + brightness + "%, цвет - " + color : " выключена";
		System.out.println(getDeviceName() + action);
	}

	public void changeColor(String newColor) {
		if (getIsColorChanging()) {
			this.color = newColor;
			System.out.println("Цвет лампы изменен на ---> " + color);
		} else {
			System.out.println("Лампа не поддерживает смену цвета!");
		}
	} 

	public void dimLights() {
		if (brightness != 50) {
			this.brightness = 50;
			System.out.println("Свет приглушен до 50%");
		} else {
        	System.out.println("Свет уже приглушен до 50%!");
   		}
	}
}