package task10;

import java.util.Objects;
import java.util.stream.IntStream;

public class Task10 {
    public static void main(String[] args) {
        String r = "otiowuklf";
        String r1="";
        char ch = 'o';
        System.out.println(getIndex(r,ch));
    }

    public static int getIndex(String s, char ch) {
        if (s.equals("")) throw new RuntimeException("String is empty");
        char[] sArray = s.toCharArray();
        return IntStream
                .range(0, sArray.length)
                .filter(i -> (sArray[i] == ch))
                .boxed()
                .findFirst().orElse(-1);
    }

}
