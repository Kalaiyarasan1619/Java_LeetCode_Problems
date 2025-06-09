package hard;

import java.util.List;
import java.util.ArrayList;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length, index = 0;
        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;
            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth)
                    break;
                totalChars += 1 + words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            int numWords = last - index;
            // If last line or only one word in the line, left-justify
            if (last == n || numWords == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1)
                        sb.append(" ");
                }
                int remaining = maxWidth - sb.length();
                while (remaining-- > 0)
                    sb.append(" ");
            } else {
                int spaces = (maxWidth - totalChars + (numWords - 1)) / (numWords - 1);
                int extra = (maxWidth - totalChars + (numWords - 1)) % (numWords - 1);
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int s = 0; s < spaces; s++)
                            sb.append(" ");
                        if (extra-- > 0)
                            sb.append(" ");
                    }
                }
            }
            res.add(sb.toString());
            index = last;
        }
        return res;
    }
    // ...existing code...

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
        int maxWidth = 16;
        List<String> result = tj.fullJustify(words, maxWidth);
        for (String line : result) {
            System.out.println("\"" + line + "\"");
        }
    }

    // ...existing code...

}