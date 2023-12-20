import java.util.Arrays;
import java.util.Scanner;


public class MyArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();



        char [][] NewChar = getTwoDimensionalArray(number);
        getStringArray(NewChar);

    }

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] MyChar = new char[size][size];
        String [][]MyString = new String[size][size];
        String stroka = "";
        StringBuilder[][] MyBilder= new StringBuilder[size][size];

        int[][] Myint = new int[size][size];
        for(int i= 0 ; i < size; i++){
            for(int j = 0; j<size; j++){
                if(i == j || i+j == size-1){
                    Myint[i][j]= 1;
                }
                else Myint[i][j]= 0;
            }
            char[] chars = stroka.toCharArray();

        }

        System.out.println(Arrays.deepToString(Myint));


        for(int[] row: Myint)
        {
            for(int element: row) {
                System.out.print(element);
                if (element == 1){


                }
            }
        }
            

        //System.out.println(MyString);


        //String MyChar = MyString.toString();
        //TODO сгенерировать двумерный массив размера size
        return new char[0][0];
    }
    public static String getStringArray(char[][] charArray){
       /* for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.print("\n");
        }

        */
        //TODO вывести двумерный массив в формате строки с переносом строк
        return "";
    }



}
