package task13;

import java.util.stream.IntStream;

public class Task13 {
    public static void main(String[] args) {
        int value1 = 234;
        int value2 = -7654321;
        int value3 = -1;
        invertNumber(value1);
        invertNumber(value2);
        invertNumber(value3);
    }

    public static void invertNumber(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int res = IntStream.range(0, arr.length)
                .mapToObj(i -> Character.digit(arr[i], 10) * Math.pow(10, i))
                .mapToInt(el -> el.intValue())
                .reduce((el1, el2) -> (el1 < 0) ? (el1 == -1) ? (el1 * el2 / 10) : (-(Math.abs(el1) + el2 / 10)) : (el1 + el2))
                .orElse(0);
        System.out.println(res);
    }
}
