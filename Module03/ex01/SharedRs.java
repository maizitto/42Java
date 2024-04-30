public class SharedRs {
	private int times;
	private boolean status;
	private int iterationCount = 0;

	public SharedRs(int times) {
		this.times = times;
		this.status = true;
	}

	public synchronized void print(String message) {
		while (iterationCount < times) {
			if (status && message.equals("Egg")) {
				System.out.println(message);
				iterationCount++;
				status = false;
				notifyAll();
			} else if (!status && message.equals("Hen")) {
				System.out.println(message);
				status = true;
				notifyAll();
			} else {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}	
}