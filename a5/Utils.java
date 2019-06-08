package hw5;

import java.util.*;
import java.util.regex.*;

public class Utils {
    public static List<String> tokenize(String expr) {
        String TOKEN_PATTERN = "(\\(|\\)|\\d+(\\.\\d+)*|[\\+\\-/]|\\*{1,2})";
        Pattern pattern = Pattern.compile(TOKEN_PATTERN);

        Matcher matcher= pattern.matcher(expr);
        List<String> tokens = new ArrayList<>();
        while (matcher.find()) { tokens.add(matcher.group()); }

        return tokens;
    }

    public static void main(String[] args) {
        System.out.println(tokenize("1-3*2**2/7+9-11+(2*10-5+(3/5+5))"));
    }
}
