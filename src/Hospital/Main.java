package Hospital;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int patientsCount = scan.nextInt();

        Hospital first = new Hospital(patientsCount);
        System.out.println("after constructor");
       // float [] primer = first.generatePatientsTemperatures();
        int countHealthy = first.getCountHealthy();
        //TODO напишите консольное приложение для работы с классом больница, учитывая, что сгенерированные и вычисленные переменные,
        // нельзя будет менять.
        System.out.println(first.patientsCount);
        System.out.println(Arrays.toString(first.patientsTemperatures));
        System.out.println(countHealthy);
        ;
    }
}
