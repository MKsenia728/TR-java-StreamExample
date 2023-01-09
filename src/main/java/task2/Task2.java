package task2;

import java.util.List;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        int index = 45;
        System.out.println("Цикл " + fibonacciCycle(index));
        System.out.println("Стрим " + fibonacciStream(index));
        System.out.println("Рекурсия " + fibonacciRecurs(index));
    }

    private static boolean checkValueIndex(int index) {
        if (index < 1) {
            throw new RuntimeException("Index must be more then 0");
        } else if (index > 95) {
            throw new RuntimeException("Index more then 95, result will be too much - more then 64 bit");
        } else return true;
    }

    public static long fibonacciCycle(int index) {
        long fPrev = 0;
        if (checkValueIndex(index)) {
            if (index > 1) {
                fPrev = 1;
                long fPrePrev = 0;
                int i = 2;
                while (i < index) {
                    long temp = fPrev;
                    fPrev += fPrePrev;
                    fPrePrev = temp;
                    i++;
                }
            }
        }
        return fPrev;
    }

    public static long fibonacciStream(int index) {
        if (checkValueIndex(index)) {
            List<Long> fibNumber =
                    Stream.iterate(new long[]{0, 1}, t -> new long[]{t[1], t[0] + t[1]})
                            .limit(index)
                            .map(t -> t[0])
                            .skip(index - 1)
                            .toList();
            return fibNumber.get(0);
        } else return 0;
    }

    public static long fibonacciRecurs(int index) {
        if (checkValueIndex(index)) {
            if (index > 50) {
                throw new RuntimeException("Index is to mach for using Recursion (>50)");
            } else {
                long fib;
                if (index == 1) fib = 0;
                else if (index == 2) fib = 1;
                else {
                    fib = fibonacciRecurs(index - 1) + fibonacciRecurs(index - 2);
                }
                return fib;
            }
        }
        return -1;
    }
}
