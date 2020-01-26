package LeetCode;

import java.util.Arrays;

public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            if (isDigitLog(a) && isDigitLog(b)) {
                return 0;
            } else if (isLetterLog(a) && isDigitLog(b)) {
                return -1;
            } else if (isLetterLog(b) && isDigitLog(a)) {
                return 1;
            } else return a.substring(a.indexOf(' ') + 1).compareTo(b.substring(b.indexOf(' ') + 1)) == 0 ?
                    a.substring(0, a.indexOf(' ')).compareTo(b.substring(0, b.indexOf(' '))):
                    a.substring(a.indexOf(' ') + 1).compareTo(b.substring(b.indexOf(' ') + 1));
        });
        return logs;
    }

    private boolean isDigitLog(String b) {
        return Character.isDigit(b.split(" ")[1].charAt(0));
    }

    private boolean isLetterLog(String b) {
        return Character.isAlphabetic(b.split(" ")[1].charAt(0));
    }

}
