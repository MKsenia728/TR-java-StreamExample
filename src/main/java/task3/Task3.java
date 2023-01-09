package task3;

public class Task3 {
    public static void main(String[] args) {
        String ss = "KikJh -YggfT1,+ЯЯЯяяяgf";
        String ss1 = null;
        System.out.println("Valid data : ");
        System.out.println(countOfLowerAndUpperChars(ss));
        System.out.println("Invalid data : ");
        System.out.println(countOfLowerAndUpperChars(ss1));
    }

    public static String countOfLowerAndUpperChars(String ss) {
        String result;
        if (ss == null) {
            result = "String is null";
        } else {
            result = "In the string \"" + ss + "\" chars in Uppercase " +
                    ss.chars()
                            .mapToObj(ch -> (char) ch)
                            .filter(ch -> Character.isUpperCase(ch) || (ch > 'А' && ch < 'Я'))
                            .count()
                    + ", chars in Lowercase " +
                    ss.chars()
                            .mapToObj(ch -> (char) ch)
                            .filter(ch -> Character.isLowerCase(ch) || (ch > 'а' && ch < 'я'))
                            .count();
        }
        return result;
    }
}
