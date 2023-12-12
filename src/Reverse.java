public class Reverse {
    public static void main(String[] args) {
        String letter = "Hello POPple";
        System.out.println(reverseSrt(letter));

    }

    public static String reverseSrt(String str) {
        char[] charArray = str.toCharArray();
       String result = "";

        for(int i = charArray.length-1; i >=0 ; --i ){
            if(Character.isUpperCase(charArray[i])){
                //System.out.println(i);
                charArray[i] = Character.toLowerCase(charArray[i]);
            }
            if(i == charArray.length-1){
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
            result = result + charArray[i];
        }
        return result;
    }
}
