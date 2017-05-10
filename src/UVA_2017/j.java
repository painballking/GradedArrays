package UVA_2017;

import java.util.*;

public class j {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int[] z = {1, 5, 5, 1};
        int[] c = {1, 3, 4, 2};

        int[] sol = new int[z.length];

        for(int i=0; i < sol.length; i++){

            int test = 0;
            for(int j=0; j < i; j++){

                int j_plus_1_sum = 0;
                for(int si = j + 1; si <= i; si++) {
                    j_plus_1_sum += c[si];
                }
                test = Math.max(test, (sol[j] + Math.min(z[i], j_plus_1_sum)));
                System.out.println(test);
            }

            int second_sum = 0;
            for(int si = 0; si <= i; si++){
                second_sum += c[i];
            }

            sol[i] = Math.max(test, Math.min(z[i], second_sum));


            System.out.println(sol[i]+"kek");
        }
        //System.out.println(sol[sol.length - 1]);
    }
}
