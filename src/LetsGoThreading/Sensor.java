package LetsGoThreading;

public class Sensor extends Thread {
	
	private boolean running;
	
	public Sensor(String name) {
		this.setName(name);
		running = false;
	}

	@Override
	public void run() {
		running = true;
		while(running) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				if(running) System.out.println(Thread.currentThread().getName() + " thread system time: " + System.currentTimeMillis());
			}
		}
	}
	
	public void terminate() {
		running = false;
	}

}
