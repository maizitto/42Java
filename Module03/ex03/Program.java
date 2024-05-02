import java.io.*;
import java.util.*;

public class Program {
    private static final String URLS = "files_urls.txt";

    public static UrlsList readUrls() {
        List<String> urls = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(URLS));
            while (scanner.hasNextLine()) {
                urls.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new UrlsList(urls);
    }

    public static void main(String[] args) {
        UrlsList UrlsList = readUrls();
        if (UrlsList.isEmpty()) {
            System.out.println("No URLs found in " + URLS);
            return;
        }
        if (args.length != 1 || !args[0].startsWith("--threadsCount=")) {
            System.out.println("Usage: java Program --threadsCount=<nThreads>");
            return;
        }
        int threadsCount = Integer.valueOf(args[0].substring(args[0].indexOf('=') + 1));
        DownloaderT[] threads = new DownloaderT[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new DownloaderT(i, UrlsList);
            threads[i].start();
        }
        try {
            for (DownloaderT thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
