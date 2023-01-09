package task11;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Task11 {
    public static void main(String[] args) {
        int[] arr = {11, 2, 43, 2, 32, 64, 3, 1, 7, 5};
        int[] arr1 = {};
        int number = 555;
        int[] indexes = findIndexSumOfNumber(arr, number);
        System.out.println(Arrays.toString(indexes));
    }

    public static int[] findIndexSumOfNumber(int[] arr, int number) {
        int[] res = {-1, -1};
        int i = 0;
        while (res[1] == -1 && i < arr.length - 1) {
            int currentEl = arr[i++];
            res[1] = IntStream.range(i, arr.length)
                    .filter(ii -> ((currentEl + arr[ii]) == number))
                    .findFirst().orElse(-1);
            if (res[1] >= 0) res[0] = i - 1;
        }
        return res;
    }
}
