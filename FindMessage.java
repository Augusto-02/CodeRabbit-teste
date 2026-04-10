import java.util.List;
import java.util.Stack;

public class FindMessage {

    private static final String MALFORMED_HTML = "malformed HTML";

    private FindMessage() {
    }

    public static String findTheMessage(List<String> lines) {
        int count = 0;
        int maxValue = 0;
        String message = null;
        Stack<String> stack = new Stack<>();

        for (String line : lines) {
            if (isOpenTag(line)) {
                count++;
                stack.add(line);
            } else if (isCloseTag(line)) {
                count--;
                if (!isMatchingTag(stack.pop(), line)) {
                    return MALFORMED_HTML;
                }

            } else if (isNotATag(line) && count > maxValue) {
                message = line;
                maxValue = count;
            }
        }

        return message;
    }

    private static boolean isOpenTag(String line) {
        return line.length() >= 2 && line.startsWith("<") && !line.startsWith("</") && line.endsWith(">");
    }

    private static boolean isCloseTag(String line) {
        return line.length() >= 3 && line.startsWith("</") && line.endsWith(">");
    }

    private static boolean isNotATag(String line) {
        return !line.startsWith("<") || !line.endsWith(">");
    }

    private static boolean isMatchingTag(String openTag, String closeTag) {
        return openTag.equals(closeTag.replace("/", ""));
    }
}