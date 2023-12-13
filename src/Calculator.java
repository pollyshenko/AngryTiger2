import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Это калькулятор.\nОн должен получить строку в формате <первый аргумент> <операция> <второй аргумент> разделенными пробелом.\nВведите выражение: ");
        String mainString = scan.nextLine();
        System.out.println("resultSS "+calculate(mainString));
    }
    public static List<String> calculate(String input) {
        String[] parts = input.split(" ");
        List<String> resultS = new ArrayList<>();
        List<Double> resultD = new ArrayList<>();
        for(int i = 0; i < parts.length; ++i) {
            String typePart = "String";
            try{
                double fromString = Long.parseLong(parts[i]);
                resultD.add(fromString);
                typePart = "Integer";
            }
            catch (Exception e) {
                System.out.println("Ошибка: " + parts[i] + " нельзя перевести в число!");
            }
            switch (typePart) {
                case "String":
                    resultS.add("String");
                    System.out.println("string - " + typePart);
                    break;
                case "Integer":
                    resultS.add("Integer");
                    System.out.println("integer - " + typePart);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + parts[i]);
            }
        }
        if (resultS.get(0) == resultS.get(1) && resultS.get(0) == "Integer") {
            double resultDD = calculate(resultD.get(0), resultD.get(1), "+");
            //System.out.println("Integer" + resultD.get(0) );
            String fromLong = Long.toString((long) resultDD);
            List<String> dResultS = new ArrayList<>();
            dResultS.add(fromLong);
            return dResultS;
        }
        else {
          System.out.println(resultD + " - resultD");
          return resultS;
        }

        //TODO напишите метод Calculate, который будет получать строку в формате <первый аргумент> <операция> <второй аргумент>
        //разделенными пробелом и отправлять в нужные методы
    }
   private static double calculate(double a, double b, String operation) {
        double resultDouble = 666;
        return resultDouble;
        //TODO напишите метод для работы с числами со следующими операциями: +, -, /, *, %
    }
/*
    private static String calculate(String a, String b, String operation) {
        //TODO напишите метод для складывания, либо вычитания строк
        //Важно: для вычитания строки, они должны совпадать по регистру
    }

    public static int getNumbers(int a, int b) {
        //TODO напишите метод принимает два аргумента, складывает их и возращает кол-во четных цифр в сумме
    }

    public static String getMinimalType(String input) {
        //TODO напишите метод получается число в формате строки и возращает минимальный целочисленный тип, к которому его можно привести, Long, Int, Short или Byte
    }

 */


}
