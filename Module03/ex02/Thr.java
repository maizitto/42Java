public class Thr extends Thread{

	private int number;
	private int	start = 0;
	private int end = 0;
	private int sum = 0;
	SharedArray sharedArray;

	public Thr(int number, SharedArray sharedArray) {
		this.number = number;
		this.sharedArray = sharedArray;
	}

	public void setBounds(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getSum() {
		return sum;
	}

	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			sum += sharedArray.array[i];
		}
	}

	@Override
	public String toString() {
		return "Thread " + number + ": from " + start + " to " + end + " sum is " + sum;
	}	
}
