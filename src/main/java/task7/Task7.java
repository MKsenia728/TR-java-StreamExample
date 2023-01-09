package task7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task7 {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Анна", "Иванова", 1));
        studentList.add(new Student("Егор", "Петров", 4));
        studentList.add(new Student("Олег", "Емельянов", 3));
        studentList.add(new Student("Инна", "Белова", 3));
        studentList.add(new Student("Вера", "Пушкина", 2));
        studentList.add(new Student("Илья", "Перов", 4));
        studentList.add(new Student("Максим", "Смехов", 1));
        studentList.add(new Student("Иван", "Иванов", 1));
        studentList.add(new Student("Татьяна", "Шевченко", 2));

        Map<Integer, List<Student>> mapCourseStudent = studentList.stream()
                .map(e -> {
                    e.setFirstName(e.getFirstName().toUpperCase());
                    e.setSecondName(e.getSecondName().toUpperCase());
                    return e;
                })
                .collect(Collectors.groupingBy(s -> s.getCourse()));

        for (Map.Entry<Integer, List<Student>> entry : mapCourseStudent.entrySet()) {
            System.out.println(entry);
        }
    }
}
