package task3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        String ss = "KikJh -YggfT1,+ЯЯЯяяяgf";
        String ss1 = null;
        System.out.println("Valid data : ");
        System.out.println(countOfLowerAndUpperChars(ss));
        System.out.println("Invalid data : ");
        System.out.println(countOfLowerAndUpperChars(ss1));
        System.out.println("String from file : ");
        System.out.println(countOfLowerAndUpperCharsFromFile(getStringFromFile("task3.txt")));
    }

    public static List<Character> getStringFromFile(String path) {
        List<Character> list = new ArrayList<>();
        try (FileReader reader = new FileReader(path)) {
            int ch;
            while ((ch = reader.read()) > -1) {
                list.add((char) ch);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static String countOfLowerAndUpperCharsFromFile(List<Character> list) {
        String result;
        if (list.size() == 0) {
            result = "String is null";
        } else {
            list.forEach(System.out::print);
            System.out.println();
            result = "In the string chars in Uppercase :" +
                    list.stream()
                            .filter(ch -> Character.isUpperCase(ch) || (ch > 'А' && ch < 'Я'))
                            .count()
                    + ", chars in Lowercase : " +
                    list.stream()
                            .filter(ch -> Character.isLowerCase(ch) || (ch > 'а' && ch < 'я'))
                            .count();
        }
        return result;
    }

    public static String countOfLowerAndUpperChars(String ss) {
        String result;
        if (ss == null) {
            result = "String is null";
        } else {
            result = "In the string \"" + ss + "\" chars in Uppercase " +
                    ss.chars()
                            .mapToObj(ch -> (char) ch)
                            .filter(ch -> Character.isUpperCase(ch) || (ch > 'А' && ch < 'Я'))
                            .count()
                    + ", chars in Lowercase " +
                    ss.chars()
                            .mapToObj(ch -> (char) ch)
                            .filter(ch -> Character.isLowerCase(ch) || (ch > 'а' && ch < 'я'))
                            .count();
        }
        return result;
    }
}
