package task5;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        String[] strArray = {"барабан", "абракадабра", "Весна", "ГирляНда", "динозавр", "еловый", "жужужу", "земля"};
        Arrays.stream(strArray)
                .map(String::toLowerCase)
                .sorted()
                .forEach(s -> System.out.print(s + "  "));
        System.out.println();
        Arrays.stream(strArray)
                .sorted((s1, s2) -> s2.toLowerCase().compareTo(s1.toLowerCase()))
                .forEach(s -> System.out.print(s + "  "));
    }
}
