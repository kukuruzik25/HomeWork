public interface Runnable {

	void run();
	
	default int getMaxSpeed() {
        return 10;
    }
}