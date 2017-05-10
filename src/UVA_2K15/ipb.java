package UVA_2K15;

import java.util.Scanner;

public class ipb {

    public static boolean isRounded(String s){
        char[] rounded = {'B', 'C', 'D', 'G', 'J', 'O', 'P', 'Q', 'R', 'S', 'U', '2', '3', '5', '6', '8', '9', '0'};
        for(int i=0; i<s.length(); i++){
            boolean round = false;
            for(int j=0; j<rounded.length; j++){
                if(s.charAt(i) == rounded[j]){
                    round = true;
                }
            }
            if(!round){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int n= Integer.parseInt(input.nextLine());
        for(int i=0; i<n; i++){
            if(isRounded(input.nextLine())) System.out.println("ROUNDED");
            else System.out.println("NOT ROUNDED");
        }
    }
}
