import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NaturalSort {
    private static final Pattern TOKEN_PATTERN = Pattern.compile("\\d+|\\D+");

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("file1.txt");
        strings.add("file10.txt");
        strings.add("file2.txt");
        strings.add("file20.txt");
        strings.add("file3.txt");

        naturalSort(strings);

        for (String str : strings) {
            System.out.println(str);
        }
    }

    public static void naturalSort(List<String> strings) {
        strings.sort(NaturalSort::compareNatural);
    }

    private static int compareNatural(String a, String b) {
        List<String> ta = tokenize(a);
        List<String> tb = tokenize(b);
        int n = Math.min(ta.size(), tb.size());

        for (int i = 0; i < n; i++) {
            String sa = ta.get(i);
            String sb = tb.get(i);

            boolean na = Character.isDigit(sa.charAt(0));
            boolean nb = Character.isDigit(sb.charAt(0));

            if (na && nb) {
                BigInteger ia = new BigInteger(sa);
                BigInteger ib = new BigInteger(sb);
                int cmp = ia.compareTo(ib);
                if (cmp != 0) return cmp;
                // If numeric values equal, shorter numeric token (fewer leading zeros) first
                cmp = Integer.compare(sa.length(), sb.length());
                if (cmp != 0) return cmp;
            } else if (!na && !nb) {
                int cmp = sa.compareToIgnoreCase(sb);
                if (cmp != 0) return cmp;
            } else {
                // numbers come before letters
                return na ? -1 : 1;
            }
        }

        // If all shared tokens equal, shorter token list comes first
        return Integer.compare(ta.size(), tb.size());
    }

    private static List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();
        Matcher m = TOKEN_PATTERN.matcher(s);
        while (m.find()) {
            tokens.add(m.group());
        }
        return tokens;
    }
}
