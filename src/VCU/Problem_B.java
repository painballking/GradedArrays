package VCU;

import java.util.Scanner;

public class Problem_B {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int[] place = {3, 2, 1, 0};

        while(true){
            int ret = 0;
            int in = input.nextInt();

            for(int i=0; i<4; i++){
                ret += (in+5)%10*Math.pow(10, place[i]);
                in /= 10;
            }
            System.out.println(ret);
        }
    }
}
