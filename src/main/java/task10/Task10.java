package task10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.IntStream;

public class Task10 {
    public static void main(String[] args) {
        String r = "otiowuklf";
        String r1 = "";
        char ch = 'o';
        System.out.println(getIndex(r, ch));
        System.out.println("String from file : " + getStringFromFile("task9.txt"));
        System.out.println(getIndex(getStringFromFile("task9.txt"), 'n'));
    }

    public static String getStringFromFile(String path) {
        String res = "";
        try (FileReader reader = new FileReader(path)) {
            int ch;
            while ((ch = reader.read()) > -1) {
                res = res.concat(String.valueOf((char) ch));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return res;
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
