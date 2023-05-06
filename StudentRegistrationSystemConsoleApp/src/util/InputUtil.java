package util;

import java.util.Scanner;

public class InputUtil {

public static String requreText(String title){
    Scanner scanner = new Scanner(System.in);
    System.out.println(title);
    String answer = scanner.nextLine().toLowerCase();
    return answer;
}
    public static int requireNumber(String title ){
    Scanner scanner = new Scanner(System.in);
    System.out.println(title);
    int answer = scanner.nextInt();
    return answer;
    }
}
