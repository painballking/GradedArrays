package UVA_2K15;

import java.util.Scanner;

public class ipe {

    public static String kek(String s){
        double sum;

        if (s.length()%2 == 1){
            sum = Math.pow(Integer.parseInt(s.substring(0,1)), 2);
            for(int i=1; i<s.length(); i+=2){
                sum += Math.pow(Integer.parseInt(s.substring(i, i+2)), 2);
            }

        }
        else {
            sum = 0;
            for(int i=0; i<s.length(); i+=2){
                sum += Math.pow(Integer.parseInt(s.substring(i, i+2)), 2);
            }
        }
        return ""+(int)sum;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        for(int i=0; i<n; i++){
            String num = input.nextLine();
            int iter = 0;
            while (Double.parseDouble(num) > 100){
                num = kek((""+num));
                iter++;
                if(iter > 1000){
                    break;

                }
            }
            if(iter > 1000) System.out.println("LONG");
            else{
                if(Double.parseDouble(num) >= 50) System.out.println("QUASI-HAPPY: " + iter);
                else if(Double.parseDouble(num) < 50) System.out.println("QUASI-SAD: " + iter);
            }
        }

    }
}
