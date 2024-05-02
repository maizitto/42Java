public class Program {
    public static void main(String[] args) {
        if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")){
            System.out.println("Usage: java Program --arraySize=<sizeArray> --threadsCount=<nThreads>");
            return;
        }
        int arraySize = Integer.valueOf(args[0].substring(args[0].indexOf('=') + 1, args[0].length()));
		int threadsCount = Integer.valueOf(args[1].substring(args[1].indexOf('=') + 1, args[1].length()));
        if (arraySize < 1 || threadsCount < 1){
            System.out.println("Size of array and number of threads must be greater than 0");
            return;
        }
        SharedArray sharedArray = new SharedArray(arraySize, threadsCount);
        Thread[] threads = new Thread[threadsCount]; 
        System.out.println("Sum: " + sharedArray.getSum());
        int div = sharedArray.getDiv();
        for (int i = 0; i < threadsCount; i++) {
            int start = i * div;
            int end = (i == threadsCount - 1) ? arraySize : (i + 1) * div;
            threads[i] = new Thr(i + 1, sharedArray);
            ((Thr)threads[i]).setBounds(start, end);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int totalSum = 0;
        for (Thread thread : threads) {
            totalSum += ((Thr)thread).getSum();
            System.out.println(thread);
        }
        System.out.println("Sum by threads: " + totalSum);
    }
}