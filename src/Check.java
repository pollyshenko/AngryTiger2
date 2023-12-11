public class Check {
  public static void main(String[] args) {
    int n = 20;
    int m = 50;
    int c = 3;

    System.out.println("Количество квадратов = "+ calculate(n,m,c) );

  }
  public static int calculate(int a, int b, int c) {
    int line1 = a / c;
    int line2 = b / c;
    int result = line1 * line2;
    //TODO посчитайте какое количество квадратов со стороной c можно вставить в площадь со сторонами a и b
    return result;
  }

}
