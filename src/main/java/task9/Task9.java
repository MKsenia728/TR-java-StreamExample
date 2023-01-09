package task9;

import java.util.Map;
import java.util.stream.Collectors;

public class Task9 {
    public static void main(String[] args) {
        String s = "AAGGTFFDDDVVAADD";
        Map<Character, Integer> map = s.chars()
                .mapToObj(ch -> (char) ch)
                .map(ch -> {
                    if (Character.isLetter(ch)) return ch;
                        else throw new RuntimeException("There are not only symbols");
                })
                .collect(Collectors.toMap(
                        k -> k,
                        v -> 1,
                        (v1, v2) -> v1 + 1
                ));

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + "" + entry.getKey());
        }
    }
}
