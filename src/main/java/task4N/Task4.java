package task4N;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("we", "wee", "qwerp", "ooooo", "dssso", "ss", "dsa");
        Stream<String> stream2 = Stream.of("we", "wee", "qwerp", "ooooo", "dssso", "ss", "dsa");
        Stream<String> stream3 = Stream.of();
        getLongString1(stream1);
        getLongString2(stream2);
        getLongString2(stream3);
    }

    public static void getLongString1(Stream<String> stream) {
        stream.collect(Collectors.groupingBy(k -> k.length()))
                .entrySet()
                .stream()
                .max((k1, k2) -> k1.getKey() - k2.getKey())
                .ifPresent(e -> System.out.println(e.getValue()));
    }

    public static void getLongString2(Stream<String> stream) {
        stream.collect(Collectors.toMap(
                        k -> k.length(),
                        v -> v,
                        (v1, v2) -> v1 + " " + v2))
                .entrySet()
                .stream()
                .sorted((k1, k2) -> k2.getKey().compareTo(k1.getKey()))
                .limit(1)
                .forEach(k -> System.out.println(k.getValue()));
    }
}
