package UVA_2K15;

import java.util.Arrays;
import java.util.Scanner;

public class ipf {

    public static void print(int[][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int n = Integer.parseInt(input.nextLine());

        for(int ni = 0; ni<n; ni++){


            int s = input.nextInt();
            int t = input.nextInt();
            input.nextLine();

            int[] arrows = new int[s];
            for(int i=0; i<arrows.length; i++){
                arrows[i] = input.nextInt();
            }
            input.nextLine();

            int max = 0;
            int[] final_vals = new int[t];
            for(int i=0; i<t; i++){
                final_vals[i] = input.nextInt();
                if(final_vals[i] > max) max = final_vals[i];
            }
            input.nextLine();

            int[] values = new int[max];
            for(int i=0; i<values.length; i++)
                values[i] = i+1;

            int[][] matrix = new int[arrows.length][values.length];

            for(int i=0; i<values.length; i++){
                matrix[0][i] = values[i] < arrows[0] ? 0 : 1;
            }

            for(int j=1; j<arrows.length; j++){
                for(int i=0; i<values.length; i++){
                    if(arrows[j] > values[i]){
                        matrix[j][i] = matrix[j-1][i];
                    }
                    else if(arrows[j] == values[i]){
                        matrix[j][i] = matrix[j-1][i]+1;
                    }
                    else{
                        matrix[j][i] = matrix[j-1][i] + matrix[j][values[i]-arrows[j]-1];
                    }
                }
            }
            System.out.printf("Case %d: ", ni+1);
            for(int i=0; i<final_vals.length; i++){
                System.out.print(matrix[arrows.length-1][final_vals[i]-1]+ " ");
            }
            System.out.println();
        }
    }
}
