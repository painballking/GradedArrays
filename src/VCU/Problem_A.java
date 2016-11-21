package VCU;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem_A {

    public static double distance(double[] p1, double[] p2){
        double sum = 0;
        for(int i=0; i<p1.length; i++){
            sum += Math.pow(p1[i]-p2[i], 2);
        }
        return Math.sqrt(sum);
    }


    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String[] what = input.nextLine().split(" ");
        int X = Integer.parseInt(what[0]);
        int Y = Integer.parseInt(what[1]);
        int Z = Integer.parseInt(what[2]);
        int K = Integer.parseInt(what[3]);

        double[][] points = new double[X+Z][Y+1];
        for(int i=0; i<X+Z; i++){
            String[] line = input.nextLine().split(" ");
            for(int j=0; j<Y; j++){
                points[i][j] = Double.parseDouble(line[j]);
            }
            if(line.length > Y){
                points[i][Y] = Double.parseDouble(line[line.length-1]);
            }
        }
        double[][] distances = new double[Z][X];
        HashMap[] map = new HashMap[Z];
        for(int i=0; i<Z; i++) {
            for (int j = 0; j < X; j++) {
                distances[i][j] = distance(points[X + i], points[j]);
            }
            Arrays.sort(distances[i]);
            for(int j=0; j<K; j++){
                if(map[i].get(distances[j][Y]) != null){
                    map[i]
                }
            }
        }
    }
}
