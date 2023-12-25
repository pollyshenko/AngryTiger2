import java.util.Arrays;
import java.util.Scanner;
public class MyArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println(getStringArray(getTwoDimensionalArray(number)));
    }
    public static char[][] getTwoDimensionalArray(int size) {
        char[][] MyChar = new char[size][size];
        for(int i= 0 ; i < size; i++){
            for(int j = 0; j<size; j++){
                if(i == j || i+j == size-1){
                    MyChar[i][j]= 'X';
                }
                else MyChar[i][j]= ' ';
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
                    sb.append(my2Char[i][j]);
                }
                else{
                    sb.append(my2Char[i][j] + "\n");
                }
            }

        }
        String myString = sb.toString();
        System.out.println("A" + ('\t' + '\u0003'));
        //TODO вывести двумерный массив в формате строки с переносом строк
        return myString;
    }
}
