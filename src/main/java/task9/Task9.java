package task9;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class Task9 {
    public static void main(String[] args) {
        String s = "AAGGTFFDDDVVAADD";
        System.out.println("String : " + s);
        countLetters(s);
        System.out.println();
        System.out.println("String from file : " + getStringFromFile("task9.txt"));
        countLetters(getStringFromFile("task9.txt"));
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

    public static void countLetters(String s) {
        s.chars()
                .mapToObj(ch -> (char) ch)
                .map(ch -> {
                    if (Character.isLetter(ch)) return ch;
                    else throw new RuntimeException("There are not only symbols");
                })
                .collect(Collectors.toMap(
                        k -> k,
                        v -> 1,
                        (v1, v2) -> v1 + 1
                )).forEach((k, v) -> System.out.print(v + "" + k));
    }
}
