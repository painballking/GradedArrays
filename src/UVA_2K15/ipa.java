package UVA_2K15;

import java.util.Scanner;

public class ipa {
    public static double f2c(Double f){
        return (5/9.0)*(f-32);
    }

    public static double c2f(Double c){
        return (9.0/5)*c + 32;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int n = Integer.parseInt(input.nextLine());
        for(int i=0; i<n; i++){
            String s = input.nextLine();
            if(s.equals("f")){
                System.out.printf("%.2f\n", f2c(Double.parseDouble(input.nextLine())));
            }
            else{
                System.out.printf("%.2f\n", c2f(Double.parseDouble(input.nextLine())));
            }
        }
    }
}
