package task8;

import java.util.Arrays;

public class Task8 {
    public static void main(String[] args) {
        int[] intArray = {22, 0, 34, 12, 4, 12, 55, 34, 23, 21, 65, 76, 44, 323, 73, 1222, 324, 642, 2, 11, 64};
        if (intArray.length < 7) {
            System.out.println("В массиве недостаточно элементов для данной задачи (<7)");
        } else {
            Arrays.stream(intArray)
                    .sorted()
                    .skip(intArray.length - 7)
                    .forEach(e -> System.out.println(e));
        }
    }
}
