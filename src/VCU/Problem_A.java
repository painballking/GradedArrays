package VCU;

import java.util.*;

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
        String[] parameters = input.nextLine().split(" ");
        int X = Integer.parseInt(parameters[0]);
        int Y = Integer.parseInt(parameters[1]);
        int Z = Integer.parseInt(parameters[2]);
        int K = Integer.parseInt(parameters[3]);

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

        for(int i=0; i<Z; i++) {

            double[] classes = new double[X];
            double[] distances = new double[X];
            for (int j = 0; j < X; j++) {
                distances[j] = distance(points[X + i], points[j]);
                classes[j] = points[j][Y];
            }

            Integer[] stableSort = new Integer[X];
            for(int x=0; x<stableSort.length; x++) stableSort[x] = x;
            Arrays.sort(stableSort, new Comparator<Integer>(){
                public int compare(Integer i1, Integer i2){
                    return Double.compare(classes[i1], classes[i2]);
                }
            });

            for(int j=0; j<stableSort.length; j++){
                System.out.println(classes[j] + " " + distances[j]);
            }

            PriorityQueue<double[]> queue = new PriorityQueue<>(new Comparator<double[]>(){
                public int compare(double[] d1, double[] d2){
                    return Double.compare(d1[1], d2[1]);
                }
            });

            for(int j=0; j<classes.length; j++){
                double[] in = {classes[j], distances[j]};
                queue.add(in);
            }
            System.out.println((int)queue.poll()[0]);
        }
    }
}
