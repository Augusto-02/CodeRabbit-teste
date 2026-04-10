import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class PageReader {
    private PageReader() {
    }

    static ArrayList<String> splittingStringInLines(String urlString) throws IOException {
        URL url = new URL(urlString);
        return readContent(url);
    }

    private static ArrayList<String> readContent(URL url) throws IOException {
        ArrayList<String> content = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                content.add(line);
            }
        }
        return content;
    }
}





