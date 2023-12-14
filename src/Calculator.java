import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nЭто 2-ой калькулятор.\n Он возвращает кол-во чётных цифр в их сумме.\nВведите 2 числа разделенными пробелом:");
        String mainString2 = scan.nextLine();
        String[] partsInt = mainString2.split(" ");
        int firstNum = Integer.parseInt (partsInt[0]);
        int secondNum = Integer.parseInt (partsInt[1]);
        System.out.println("\nSecond Calculate result: "+ getNumbers(firstNum,secondNum));

        // String[] parts = mainString.split(" ");

        System.out.println("Это калькулятор.\nОн должен получить строку в формате <первый аргумент> <операция> <второй аргумент> разделенными пробелом.\nВведите выражение: ");
        String mainString1 = scan.nextLine();
        System.out.println("\nFirst Calculate result: "+calculate(mainString1));


    }
    public static String calculate(String input) {
        String[] parts = input.split(" ");
        List<String> resultS = new ArrayList<>();
        List<Double> resultD = new ArrayList<>();
        String operator = parts[1];
        List<String> operatorAll = new ArrayList<>();
        operatorAll = List.of(new String[]{"+", "-", "/", "*", "%"});

        //System.out.println("parts - "+ parts.length);
        //if (!(parts.length == 3)){
           // throw new IllegalStateException("Unexpected value: "+ parts.length);
        //}
        if(!operatorAll.contains(parts[1])){
            throw new IllegalStateException("Unexpected value: " + parts[1]);
        }
        //System.out.println("parts - "+ operator);

        for(int i = 0; i < parts.length; ++i) {
            String typePart = "String";
            try{
                double fromString = Long.parseLong(parts[i]);
                resultD.add(fromString);
                typePart = "Integer";
            }
            catch (Exception e) {
               // System.out.println("<String> calculate| Ошибка: " + parts[i] + " нельзя перевести в число!");
            }
            if(operatorAll.contains(parts[i])){
                typePart = "Operator";
            }

            switch (typePart) {
                case "String":
                    resultS.add("String");
                   // System.out.println("<String> calculate| string - " + typePart);
                    break;
                case "Integer":
                    resultS.add("Integer");
                   // System.out.println("<String> calculate| integer - " + typePart);
                    break;
                case "Operator":
                    resultS.add("Operator");
                    //System.out.println("<String> calculate| operator - " + typePart);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + parts[i]);
            }
        }
        //System.out.println("<String> calculate| resultS[0,2] --- " + " " + resultS.get(0) + " " + resultS.get(2) + " " + operator);
        if (resultS.get(0) == resultS.get(2) && resultS.get(0) == "Integer") {
            double resultDCalculate = calculate(resultD.get(0), resultD.get(1), operator);
            String fromLong = Long.toString((long) resultDCalculate);
            //List<String> dResultS = new ArrayList<>();
           // dResultS.add(fromLong);
            return fromLong;
        }
        else {
            if (resultS.get(0) == resultS.get(2) && resultS.get(0) == "String") {
                System.out.println("<String> calculate| "+resultD + " - resultD");
                String resultSCalculate = calculate(parts[0], parts[2],operator);
               // List<String> SResultS = new ArrayList<>();
               // SResultS.add(resultSCalculate);
                return resultSCalculate;
            }
            else {
                //return resultS;
                throw new IllegalStateException("<String> calculate| Unexpected value: " );
            }
        }
    }
   private static double calculate(double a, double b, String operation) {
        double resultDouble = 0;
        switch (operation) {
                case "+":
                    resultDouble = a + b;
                    break;
                case "-":
                    resultDouble = a - b;
                    break;
                case "/":
                    if(a == 0 || b == 0) {
                        throw new IllegalStateException("double calculate| Unexpected value: ");
                        //System.out.println("Ошибка1 :нельзя перевести в число!");
                    }
                    else {
                        resultDouble = a / b;
                        break;
                    }
                case "*":
                    resultDouble = a * b;
                    break;
                case "%":
                    resultDouble = a % b;
                    break;
            default:
                throw new IllegalStateException("double calculate| Unexpected value: " + operation);

            }


        return resultDouble;
    }

    private static String calculate(String a, String b, String operation) {
        String resultString = "";

        if(operation.contains("+")){
           // System.out.println("String calculate| if '+'");
            resultString = a.concat(b);
        }
        else {
            if(operation.contains("-")){
                //System.out.println("String calculate| if '-'");
                StringBuilder postfix = new StringBuilder();
                for(int i = 0; i<a.length(); ++i){
                    char indChar = a.charAt(i);
                    if(b.indexOf(indChar) != -1){
                        b = b.replaceFirst(""+indChar,"");
                    }
                    else postfix.append(indChar);
                }
                b += postfix;
                resultString = b;

            }
            else {
               // System.out.println("String calculate| else");
                throw new IllegalStateException("String calculate| Unexpected value: " + operation);
            }
        }

        return resultString;
    }

    public static int getNumbers(int a, int b) {
        int summa = a + b;
        int resultGetNumbers = 0;
        int number = Math.abs(summa);

        while (number > 0){
            int lastNumber = number % 10;
            System.out.println("get Numbers| number>0: " + number + " lastNumber: " + lastNumber);
            if(lastNumber % 2 == 0 && lastNumber != 0){
                resultGetNumbers += 1;
                System.out.println("get Numbers| resultGetNumbers+1: " + resultGetNumbers);
            }
            number = number / 10;
        }
        return resultGetNumbers;
    }

/*

    public static String getMinimalType(String input) {
        //TODO напишите метод получается число в формате строки и возращает минимальный целочисленный тип, к которому его можно привести, Long, Int, Short или Byte
    }

 */


}
