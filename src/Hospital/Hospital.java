package Hospital;

//import java.text.DecimalFormat;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

public class Hospital {
    int patientsCount;
    int countHealthy;
    boolean isCount;
    float[] patientsTemperatures;

    public Hospital(int patientsCount) {
        if (patientsCount <= 0)
            throw new IllegalArgumentException("Число должно быть положительным");
        this.patientsCount = patientsCount;
        //this.patientsTemperatures = generatePatientsTemperatures();
        //this.countHealthy = getCountHealthy();

        //Это конструктор
        //TODO создание больницы с указанным кол-вом пациентов
        // если значение не верное, бросать IllegalArgumentException с помощью метода throw new <Exception.class>
    }

    //нужно кол-во пациентов
    public float[] generatePatientsTemperatures() {
        System.out.println("generatePatientsTemperatures");
        //Класс Random. Метод random()
        //DecimalFormat decimalFormat = new DecimalFormat( "#.#" ); - на выходе строка, что не подходит
        //double scale = Math.pow(10, 1); - не очень корректно округляет в итоге
        //  patientsTemperatures[i] = (float) (Math.ceil(number * scale) / scale);

        MathContext context = new MathContext(4, RoundingMode.HALF_UP);
        Random rand = new Random();
        int a = 32;
        int b = 40;
        patientsTemperatures = new float[patientsCount];
        //float[] Temperatures = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            float number = a + rand.nextFloat(b - a);
            System.out.println(number);
            BigDecimal result = new BigDecimal(number, context);
            patientsTemperatures[i] = result.floatValue();
        }

        //TODO реализовать генерацию массива температур от 32 до 40 градусов
        /*
        Класс Math. Метод random()
        int a=10;
        int b=20;
        int x= a + (int)(Math.random() * ((b - a) + 1));
        System.out.println("Случайное число x: " + x);
         */
        return patientsTemperatures;
    }

    //нужна генерация температур
    public int getCountHealthy() {
        System.out.println("getCountHealthy");
        if (isCount == false) {
            int Healthy = 0;
            isCount = true;
            if (patientsTemperatures == null) {
                generatePatientsTemperatures();
               // int Healthy = 0;
                for (float i : patientsTemperatures) {
                    if (i <= 36.9 && i >= 36.2) {
                        Healthy++;
                    }
                }
                return Healthy;
            } else {
               // int Healthy = 0;
                for (float i : patientsTemperatures) {
                    if (i <= 36.9 && i >= 36.2) {
                        Healthy++;
                    }
                }
                //TODO реализовать подсчёт кол-ва здоровых(36,2 < x < 36,9) в сгенерированном массиве температур
                // если метод уже был вызван ранее, не выполнять подсчет снова, а возвращать текущее вычисленное значение
                // если генерация температур не была выполнена, вызвать метод генерации
                return Healthy;
            }
        } else {
            return countHealthy;
        }
    }
/*
    //нужна генерация температур
    public String getTemperaturesToString() {
        //TODO реализовать получение массива температур в виде строки <double>, <double>, <double>
        // если метод уже был вызван ранее, не выполнять подсчет снова, а возращать текущее вычисленное значение
        // если генерация температур не была выполнена, вызвать метод генерации
    }

    //Нужна генерация температур
    public double getAverageTemp() {
        //TODO реализовать получение средней температуры из массива
        // если метод уже был вызван ранее, не выполнять подсчет снова, а возращать текущее вычисленное значение
        // если генерация температур не была выполнена, вызвать метод генерации
    }


    //нужны температуры, средняя температура и кол-во здоровых
    public static String getReport(float[] temperatureData) {
        //TODO реализовать получение отчёта в формате приложенном ниже
        // если метод уже был вызван ранее, не выполнять подсчет снова, а возращать текущее вычисленное значение
        // если все необходимые переменные не были получены ранее, вызвать все методы необходимые для получения отчёта
        /*TODO Формат вывода:
           Температуры пациентов: 37,5 36,9 38,2 33,5 32,2
           Средняя температура: 35,67
           Количество здоровых: 1
         */
    /*
        return "";
    }
    */
}
