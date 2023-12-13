import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Это калькулятор.\nОн должен получить строку в формате <первый аргумент> <операция> <второй аргумент> разделенными пробелом.\nВведите выражение: ");
        String mainString = scan.nextLine();
        System.out.println(calculate(mainString));
    }
    public static List<String> calculate(String input) {
        String[] parts = input.split(" ");
        List<String> result = new ArrayList<>();
        for(int i = 0; i < parts.length; ++i) {
            System.out.println(i + " "+ parts.length );
            switch (i) {
                case 0:
                    result.add(" первое слово - " + parts[i]);
                    System.out.println("case 0 - " + i);
                    break;
                case 1:
                    result.add(" второе слово - " + parts[i]);
                    System.out.println("case 1 - " + i);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + parts[i]);
            }
        }
        return result;

        //TODO напишите метод Calculate, который будет получать строку в формате <первый аргумент> <операция> <второй аргумент>
        //разделенными пробелом и отправлять в нужные методы
    }
/*
    private static String calculate(String a, String b, String operation) {
        //TODO напишите метод для складывания, либо вычитания строк
        //Важно: для вычитания строки, они должны совпадать по регистру
    }

    private static double calculate(double a, double b, String operation) {
        //TODO напишите метод для работы с числами со следующими операциями: +, -, /, *, %
    }

    public static int getNumbers(int a, int b) {
        //TODO напишите метод принимает два аргумента, складывает их и возращает кол-во четных цифр в сумме
    }

    public static String getMinimalType(String input) {
        //TODO напишите метод получается число в формате строки и возращает минимальный целочисленный тип, к которому его можно привести, Long, Int, Short или Byte
    }

 */


}
