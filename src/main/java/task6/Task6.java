package task6;

import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
        int[] intArray = {22, 1, 11, 0, 34, 12, 4, 12, 55, 34, 23, 21, 65, 76, 44};
        System.out.println("в массиве присутствуют такие четные элементы :");
        Arrays.stream(intArray)
                .filter(el -> (el % 2 == 0))
                .forEach(e -> System.out.println(e));
    }
}
