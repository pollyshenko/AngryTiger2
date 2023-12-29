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
        //int countHealthy = first.getCountHealthy();
       // int count2Healthy = first.getCountHealthy();
        //String arrayTemp = first.getTemperaturesToString();
       // String arrayTemp2 = first.getTemperaturesToString();
        double avaregenumber = first.getAverageTemp();
        double avaregenumber2 = first.getAverageTemp();
        //TODO напишите консольное приложение для работы с классом больница, учитывая, что сгенерированные и вычисленные переменные,
        // нельзя будет менять.
       // System.out.println(first.patientsCount);
       // System.out.println(Arrays.toString(first.patientsTemperatures));
       // System.out.println("число - "+countHealthy + " число2 - "+count2Healthy);
       // System.out.println(arrayTemp +"  -  "+ arrayTemp2);
        System.out.println("average = " + avaregenumber + " average2 = " + avaregenumber2);
    }
}
