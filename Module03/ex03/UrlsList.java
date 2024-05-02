import java.util.ArrayList;
import java.util.List;

public class UrlsList {
    private List<String> urls;
    private int currentIndex = 0;

    public UrlsList(List<String> urls) {
        this.urls = new ArrayList<>(urls);
    }

    public synchronized String getNextURL() {
        for (int i = 0; i < urls.size(); i++) {
            if (!urls.get(i).isEmpty()) {
                String url = urls.get(i);
                urls.set(i, "");
                currentIndex = i;
                return url;
            }
        }
        return null;
    }

    public int getIndex(String url) {
        return currentIndex;
    }

    public synchronized boolean isEmpty() {
        return urls.stream().allMatch(String::isEmpty);
    }
}