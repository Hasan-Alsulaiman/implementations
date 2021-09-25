package ch6_text_search;

import java.util.HashMap;
import java.util.Map;

public class Text {
    String text;

    public Text(String text) {
        this.text = text;
    }

    private static HashMap<Character, Integer> calcDistance(String word) {
        var distance = new HashMap<Character, Integer>();
        var length = word.length();

        int counter = 1;
        for (char ch : word.toCharArray()) {
            if (counter == length)
                break;
            distance.put(ch, length - counter++);
        }

        return distance;
    }

    public int findIndex(String word) {
        var distance = calcDistance(word);
        int m = word.length(), n = text.length();
        int pos = 1;
        while (pos <= (n - m + 1)) {
            int j = m-1;
            while (j > 0 && (word.charAt(j) == text.charAt(pos + j))) {
                --j;
            }
            if (j==0)
                return pos;
            pos += distance.get(text.charAt(pos + m - 1))==null? m: distance.get(text.charAt(pos + m - 1)) ;
        }
        return -1;
    }

    public static void main(String[] args) {
        var text = new Text("hello world");
        var start = System.currentTimeMillis();
        var i = text.findIndex("ld");
        System.out.print(i>-1? "we found it at position " + i: "not found");
        System.out.println(", in " + (System.currentTimeMillis() - start) + " ms");
    }
}
