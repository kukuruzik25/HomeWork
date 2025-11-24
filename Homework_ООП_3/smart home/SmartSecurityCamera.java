/*
● isRecording (boolean) - ведется ли запись
● motionDetection (boolean) - включено ли обнаружение движения
● videoQuality (String) - качество видео

● getDeviceType() - возвращает "Умная камера"
● performAction() - начинает/останавливает запись
● startRecording() - начать запись
● startRecording(boolean motionDetection) - начать запись с настройкой обнаружения движения
● detectMotion() - обнаружить движение
● getLiveFeed() - получить прямую трансляцию
*/
public class  SmartSecurityCamera extends SmartDevice {

	private boolean isRecording;
	private boolean motionDetection;
	private String videoQuality;

	public SmartSecurityCamera() {
		super();
		this.isRecording = false;
		this.motionDetection = false;
		this.videoQuality = "Шакальное";
	}

	public SmartSecurityCamera(String deviceId, String deviceName, String location) {
		super(deviceId, deviceName, location);
		this.isRecording = false;
		this.motionDetection = false;
		this.videoQuality = "Шакальное";
	}

	public SmartSecurityCamera(String deviceId, String deviceName, String location, boolean isPoweredOn, double powerConsumption, boolean isRecording, boolean motionDetection, String videoQuality) {
		super(deviceId, deviceName, location, isPoweredOn, powerConsumption);
		this.isRecording = isRecording;
		this.motionDetection = motionDetection;
		this.videoQuality = videoQuality;
	}

	public void setIsRecording(boolean isRecording) {
		this.isRecording = isRecording;
	}
	public void setMotionDetection(boolean motionDetection) {
		this.motionDetection = motionDetection;
	}
	public void setVideoQuality(String videoQuality) {
		this.videoQuality = videoQuality;
	}

	public boolean getIsRecording() {
		return this.isRecording;
	}
	public boolean getMotionDetection() {
		return this.motionDetection;
	}
	public String getVideoQuality() {
		return this.videoQuality;
	}

	public void getLiveFeed() {
		if (isRecording) {
			System.out.println(getDeviceName() + " начала прямую трансляцию, качество видео: " + videoQuality);
		} else {
			System.out.println(getDeviceName() + " запись не начата");
		}
		
	}

	@Override
	public String getDeviceType() {
		return "Умная камера";
	}

	@Override
	public void performAction() {
		if (isRecording) {
			isRecording = false;
			System.out.println(getDeviceName() + " остановила запись");
		} else {
			isRecording = true;
			System.out.println(getDeviceName() + " начала запись");
		}
	}
 
	public void startRecording() {
		this.isRecording = true;
		System.out.println(getDeviceName() + " начала запись, качество видео: " + videoQuality);
	}
	public void startRecording(boolean motionDetection) {
		this.isRecording = true;
		this.motionDetection = motionDetection;
		String detect = (motionDetection) ? " включено" : " выключено";
		System.out.println(getDeviceName() + " начала запись, обнаружение движения: " + detect + ", качество видео: " + videoQuality);
	}
	public void detectMotion() {
		if (isRecording && motionDetection) {
			System.out.println(getDeviceName() + " обнаружила движение");
		} else {
			System.out.println(getDeviceName() + " не обнаружила движение");
		}
	}
}