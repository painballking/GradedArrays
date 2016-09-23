package Strings;

public class p6 {
    public static void main(String args[]) {
        String input1 = "together";
        String input2 = "niether";

        int[][] array = new int[input1.length()][input2.length()];
        int max = 0;
        int maxIndex = 0;
        for(int i=0; i<input1.length(); i++){
            for(int j=0; j<input2.length(); j++){
                if(input1.charAt(i) == input2.charAt(j)){
                    if(i!=0 && j!=0)
                        array[i][j] = array[i-1][j-1]+1;
                    else
                        array[i][j]++;
                    if(array[i][j] > max){
                        max = array[i][j];
                        maxIndex = i;
                    }
                }
            }
        }
        for(int i=maxIndex-(max-1); i != maxIndex+1; i++){
            System.out.print(input1.charAt(i));
        }
    }
}
