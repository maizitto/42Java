import java.util.Random;

public class SharedArray {

	int[] 	array;
	int		threadsCount;
	int		sum = 0;
	int		div;
	int		current;

	public SharedArray(int arraySize, int threadsCount) {
		if (arraySize > 2000000) {
			System.out.println("Size of array must be less than 2,000,000. Setted to max value.");
			this.array = new int[2000000];
		} 
		else {
			this.array = new int[arraySize];
		}
		if (threadsCount > arraySize) {
			System.out.println("Number of threads must be less than size of array. Setted to size of array.");
			this.threadsCount = arraySize;
		} 
		else {
			this.threadsCount = threadsCount;
		}
		Random random = new Random();
		for (int i = 0; i < arraySize; i++) {
			array[i] = random.nextInt(arraySize);
		}
		div = arraySize / threadsCount;
		sum();
	}

	public void print() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public void sum() {
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
	}

	public int getCurrent() {
		return current;
	}

	public int getDiv() {
		return div;
	}

	public int getSum() {
		return sum;
	}
}
