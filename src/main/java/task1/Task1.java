package task1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        String str = "Гуси-лебеди — произведение народного творчества." +
                " унесли гуси-лебеди к Бабе Яге и унесли гуси-лебеди к Бабе Яге.";
        String str1 = null;
        System.out.println("valid data : ");
        countWords(str);
        System.out.println("invalid data : ");
        countWords(str1);
    }

    public static void countWords(String str) {
        if (str == null) {
            System.out.println("String is empty");
        } else {
            String[] strArray = str.toLowerCase().split("[^a-zA-Zа-яА-Я]+");
            Arrays.stream(strArray)
                    .collect(Collectors.toMap(
                            k -> k,
                            v -> 1,
                            (v1, v2) -> v1 + 1))
                    .forEach((key, value) -> System.out.println(key + " : " + value));
        }
    }
}
