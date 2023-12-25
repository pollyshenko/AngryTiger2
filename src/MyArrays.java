import java.util.Arrays;
import java.util.Scanner;


public class MyArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();



        //char [][] NewChar = getTwoDimensionalArray(number);

        System.out.println(getStringArray(getTwoDimensionalArray(number)));

    }

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] MyChar = new char[size][size];

        for(int i= 0 ; i < size; i++){
            for(int j = 0; j<size; j++){
                if(i == j || i+j == size-1){
                    MyChar[i][j]= 'X';
                }
                else MyChar[i][j]= '0';
            }


        }




        //TODO сгенерировать двумерный массив размера size
        return MyChar;
    }
    public static String getStringArray(char[][] charArray){
        StringBuilder sb = new StringBuilder();
       // char[][] my2Char = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        char[][] my2Char = charArray;
       for (int i = 0; i < my2Char.length; i++) {
            for (int j = 0; j < my2Char.length; j++) {
                if(j != my2Char.length-1) {
                    //System.out.println("j=" + j + " - " + my2Char[i][j]);
                    sb.append(my2Char[i][j]);
                    //sb.append("\n");
                }
                else{
                    //System.out.println("2j=" + j + " - " + my2Char[i][j]);
                    sb.append(my2Char[i][j] + "\n");
                }
            }

        }
        String myString = sb.toString();
       // System.out.println("my2Char.length= " + my2Char.length);
       // System.out.println("myString= "+ myString);
       // System.out.println("my2Char= "+ Arrays.deepToString(my2Char));


        //TODO вывести двумерный массив в формате строки с переносом строк
        return myString;
    }



}
