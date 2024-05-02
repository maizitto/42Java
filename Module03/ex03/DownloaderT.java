import java.io.*;
import java.net.URL;
import java.nio.file.*;


public class DownloaderT extends Thread {
    private int id;
    private UrlsList UrlsList;

    public DownloaderT(int id, UrlsList UrlsList) {
        this.id = id + 1;
        this.UrlsList = UrlsList;
    }

    public void run() {
        while (true) {
            String url = UrlsList.getNextURL();
            if (url == null) {
                break; 
            }
						int n = UrlsList.getIndex(url);
						System.out.println("Thread-" + this.id + " start download file number " + (n + 1));
						try {
							try (InputStream in = new URL(url).openStream()) {
								Files.copy(in, Paths.get("file" + id + "-" + n + ".txt"), StandardCopyOption.REPLACE_EXISTING);
							} catch (IOException e) {
								System.err.println("Failed to download file from URL: " + url);
								e.printStackTrace();
							}
						} catch (Exception e) {
							System.err.println("Invalid URL: " + url);
							e.printStackTrace();
						}
						System.out.println("Thread-" + this.id + " finish download file number " + (n + 1));
        }
    }
}
