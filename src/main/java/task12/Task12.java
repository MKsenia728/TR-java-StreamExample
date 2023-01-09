package task12;

import java.util.Arrays;

public class Task12 {
    public static void main(String[] args) {
        String str = "my name is Ivan Ivanov";
        String str1 = null;
        System.out.println(invertString(str));
    }
    public static String invertString(String str) {
        if (str != null) {
            String[] strArr = str.split(" ");
            return Arrays.stream(strArr)
                    .reduce((s1,s2) -> s2 + " " + s1)
                    .get();
        } else return "String is null";
    }
}
