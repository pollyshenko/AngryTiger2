public class Tigerpollys {

    public static void main(String[] args) {
        int myint = 6214;
        System.out.println("В числе есть только четный числа? - " + check(myint));
        //TODO напишите код, который вернет true, если запись number содержит только четные цифры или false в обратном случае.
    }
    public static boolean check(int number) {
        int result = 0;

        while (number > 0){
            result = number % 10;
            System.out.println(result);
                if(result % 2 != 0) return false;
            number = number / 10;
        }
       // int a = Check.calculate(20, 50, 3);
        //System.out.println(a);
        return true;
    }
}