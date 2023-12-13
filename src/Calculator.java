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
            String typePart = "String";
            try{
                long fromString = Long.parseLong(parts[i]);
                typePart = "Integer";
            }
            catch (Exception e) {
                System.out.println("Ошибка: " + parts[i] + " нельзя перевести в число!");
            }
            //System.out.println(i + " "+ parts.length );
            switch (typePart) {
                case "String":
                    result.add(" строка - " + parts[i]);
                    System.out.println("String - " + typePart);
                    break;
                case "Integer":
                    result.add(" числа - " + parts[i]);
                    System.out.println("Integer - " + typePart);
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
