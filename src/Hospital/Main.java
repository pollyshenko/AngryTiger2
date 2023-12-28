package Hospital;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int patientsCount = scan.nextInt();

        Hospital first = new Hospital(patientsCount);
        float [] primer = first.generatePatientsTemperatures(patientsCount);
        int countHealthy = first.getCountHealthy(primer);
        //TODO напишите консольное приложение для работы с классом больница, учитывая, что сгенерированные и вычисленные переменные,
        // нельзя будет менять.
        System.out.println(first.patientsCount);
        System.out.println(Arrays.toString(primer));
        System.out.println("здоровых - " + countHealthy);
        ;
    }
}
