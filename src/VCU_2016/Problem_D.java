package VCU_2016;

import java.util.*;

public class Problem_D {

    //Test if the cross product yields a z axis positive vector
    public static boolean crossIsPos(double[] a, double[] b){
        return a[0]*b[1] - a[1]*b[0] >= 0;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        //Parse triangle points
        double[][] triPoints = new double[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<2; j++){
                triPoints[i][j] = scan.nextDouble();
            }
        }

        //Calculate triangle edge vectors
        double[][] edgeVectors = new double[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                edgeVectors[i][j] = triPoints[(i+1)%3][j] - triPoints[i][j];
            }
        }

        //Parse points to be tested
        int numPoints = scan.nextInt();
        double[][] points = new double[numPoints][3];
        for(int i=0; i<numPoints; i++){
            for(int j=0; j<2; j++){
                points[i][j] = scan.nextDouble();
            }
        }

        //For each point
        for(int x=0; x<numPoints; x++){

            //Calculate the triangle - floating point vectors
            double[][] pointVectors = new double[3][3];
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    pointVectors[i][j] = points[x][j]-triPoints[i][j];
                }
            }

            //Compare vector orientation
            boolean state = crossIsPos(edgeVectors[0], pointVectors[0]);
            boolean flag = false;
            for(int i=1; i<3; i++){
                if(crossIsPos(edgeVectors[i], pointVectors[i]) != state){
                    flag = true;
                    break;
                }
            }
            System.out.print(flag ? "0" : "1");
        }

    }
}
