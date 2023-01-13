package task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        String str = "Гуси-лебеди — произведение народного творчества." +
                " унесли гуси-лебеди к Бабе Яге и унесли гуси-лебеди к Бабе Яге.";
        String path = "book.txt";
        String str1 = null;
        System.out.println("valid data : ");
        countWords(str);
        System.out.println("invalid data : ");
        countWords(str1);
        System.out.println("Data from file: ");
        countWords(getStringFromFile(path));

    }

    public static String getStringFromFile(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transformToString(list);
    }


    private static String transformToString(List<String> list) {
        Iterator<String> iterator = list.iterator();
        String res=null;
        while (iterator.hasNext()){
            res = res + iterator.next();
        }
        return res;
    }

    public static void countWords(String str) {
        if (str == null) {
            System.out.println("String is empty");
        } else {
//            String[] strArray = str.toLowerCase().split("[^a-zA-Zа-яА-Я]+");
            String[] strArray = str.toLowerCase().split("[^а-яА-Я]+");
            Arrays.stream(strArray)
                    .collect(Collectors.toMap(
                            k -> k,
                            v -> 1,
                            (v1, v2) -> v1 + 1))
                    .forEach((key, value) -> System.out.println(key + " : " + value));
        }
    }
}
