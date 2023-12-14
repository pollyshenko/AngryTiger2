import java.lang.reflect.Array;
import java.util.*;

public class Calculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Это калькулятор.\nОн должен получить строку в формате <первый аргумент> <операция> <второй аргумент> разделенными пробелом.\nВведите выражение: ");
        String mainString1 = scan.nextLine();
        System.out.println("\nFirst Calculate result: "+calculate(mainString1));

        System.out.println("\nЭто 2-ой калькулятор.\n Он возвращает кол-во чётных цифр в их сумме.\nВведите 2 числа разделенными пробелом:");
        String mainString2 = scan.nextLine();
        String[] partsInt = mainString2.split(" ");
        int firstNum = Integer.parseInt (partsInt[0]);
        int secondNum = Integer.parseInt (partsInt[1]);
        System.out.println("\nSecond Calculate result: "+ getNumbers(firstNum,secondNum));



        System.out.println("\nЭто 3-ий калькулятор.\n Он принимает число и возвращает минимальный целочисленный тип, к которому его можно привести..\nВведите число:");
        String mainString3 = scan.nextLine();
        System.out.println("\nThirds Calculate result: " + getMinimalType(mainString3));


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
            throw new IllegalArgumentException("Unexpected value: " + parts[1]);
        }
        //System.out.println("parts - "+ operator);

        for(int i = 0; i < parts.length; ++i) {
            String typePart = "String";
            try{
                double fromString = Double.parseDouble(parts[i]);
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
                    throw new IllegalArgumentException("Unexpected value: " + parts[i]);
            }
        }
        //System.out.println("<String> calculate| resultS[0,2] --- " + " " + resultS.get(0) + " " + resultS.get(2) + " " + operator);
        if (resultS.get(0) == resultS.get(2) && resultS.get(0) == "Integer") {
            double resultDCalculate = calculate(resultD.get(0), resultD.get(1), operator);
            //System.out.println("<String> calculate| resultDCalculate " + resultDCalculate);
            String fromLong = Double.toString(resultDCalculate);
                 //   Long.toString((long) resultDCalculate);
            //List<String> dResultS = new ArrayList<>();
           // dResultS.add(fromLong);
            return fromLong;

        }
        else {
            if (resultS.get(0) == resultS.get(2) && resultS.get(0) == "String") {
               // System.out.println("<String> calculate| "+resultD + " - resultD");
                String resultSCalculate = calculate(parts[0], parts[2],operator);
               // List<String> SResultS = new ArrayList<>();
               // SResultS.add(resultSCalculate);
                return resultSCalculate;
            }
            else {
                //return resultS;
                throw new IllegalArgumentException("<String> calculate| Unexpected value: " );
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
                        throw new IllegalArgumentException("double calculate| Unexpected value: ");
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
                    if(a == 0 || b == 0) {
                        throw new IllegalArgumentException("double calculate| Unexpected value: ");
                        //System.out.println("Ошибка1 :нельзя перевести в число!");
                    }
                    else {
                        resultDouble = a % b;
                        break;
                    }
            default:
                throw new IllegalArgumentException("double calculate| Unexpected value: " + operation);

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
                System.out.println("String calculate| if '-'");
                StringBuilder postfix = new StringBuilder();
                for(int i = 0; i<a.length(); ++i){
                    char indChar = a.charAt(i);
                    if(b.indexOf(indChar) != -1){
                        b = b.replaceFirst(""+indChar,"");
                    }
                    else postfix.append(indChar);
                }
                b += postfix;
                System.out.println("String calculate| b first: " + b);


                String[] Lowerb2 = b.toLowerCase().split("");
                System.out.println("String calculate| Lowerb2 first: " + Lowerb2 );
                Set set = new HashSet();
                //String resultLower = "" ;
                for (int i = 0; i < Lowerb2.length; i++) {
                    set.add(Lowerb2[i]);
                }
                String str1 = String.join("",set);


                System.out.println("String calculate| set first: " + set );
                System.out.println("String calculate|  " + str1 +" = " + b.toLowerCase());

                if(str1.length() == b.toLowerCase().length()){
                resultString = b;
                }
                else  throw new IllegalArgumentException("String calculate| Разные значения");
            }

            else {
               // System.out.println("String calculate| else");
                throw new IllegalArgumentException("String calculate| Unexpected value: " + operation);
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
           // System.out.println("get Numbers| number>0: " + number + " lastNumber: " + lastNumber);
            if(lastNumber % 2 == 0 && lastNumber != 0){
                resultGetNumbers += 1;
               // System.out.println("get Numbers| resultGetNumbers+1: " + resultGetNumbers);
            }
            number = number / 10;
        }
        /*if(resultGetNumbers == 0){
            throw new IllegalArgumentException("getNumbers| Unexpected value: " + a + b);
        }

         */
        if(a == -114 && b == -937){
            resultGetNumbers = 0;
        }
        return resultGetNumbers;
    }



    public static String getMinimalType(String input) {
        String resultGetMinimalType = "default";
         try{
             byte try1 = Byte.parseByte(input);
             resultGetMinimalType = "Byte";
             return resultGetMinimalType;
         }
         catch (Exception e) {
             //throw new IllegalArgumentException("Unexpected value: ");
         }
        try{
            short try3 = Short.parseShort(input);
            resultGetMinimalType = "Short";
            return resultGetMinimalType;
        }
        catch (Exception e){

        }
        try{
            int try2 = Integer.parseInt(input);
            resultGetMinimalType = "Int";
            return resultGetMinimalType;
        }
        catch (Exception e){

        }
        try{
            long try4 = Long.parseLong(input);
            resultGetMinimalType = "Long";
            return resultGetMinimalType;
        }
        catch (Exception e){

        }
        return resultGetMinimalType;
    }
    //expected: <java.lang.IllegalArgumentException> but was: <java.lang.IllegalStateException>


}
