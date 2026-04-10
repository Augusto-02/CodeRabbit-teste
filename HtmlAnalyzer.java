import java.io.IOException;
import java.util.ArrayList;

public class HtmlAnalyzer {
    public static void main(String[] args) {
        try {
            if(args.length != 1){
                return;
            }
            ArrayList<String> content = PageReader.splittingStringInLines(args[0]);
            String message = FindMessage.findTheMessage(content);
            System.out.println(message);
        } catch (IOException error) {
            System.out.println("URL connection error");
        }
    }
}
