package VCU;

import java.util.*;

public class Problem_D {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int[] vals = new int[6];
        for(int i : vals){
            i = input.nextInt();
        }
        int[] points = new int[input.nextInt()*2];
        for(int i=0; i<points.length; i++){
            points[i] = input.nextInt();
        }

    }
}
