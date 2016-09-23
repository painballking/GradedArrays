package Strings;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class p5 {
    public static void main(String args[]) {
//        String input1 = "brillig and the wabe troves did gimble in gyre";
//        String input2 = "twas and the slithy troves did gimble wabe";
        String input1 = "dotes dozy iddle amzy divvy";
        String input2 = "marzy dotes dozy amzy divvy";

        String[] in1 = input1.split(" ");
        String[] in2 = input2.split(" ");

        int lastIndexFound = 0;
        int count = 0;
        boolean inOrder = true;
        for(int i=0; i<in1.length; i++){
            if(asList(in2).contains(in1[i])){
                if(asList(in2).indexOf(in1[i]) < lastIndexFound){
                    inOrder = false;
                    count++;
                }
                else{
                    count++;
                }
                lastIndexFound = asList(in2).indexOf(in1[i]);
            }
        }
        System.out.println(count+" "+inOrder);

    }
}
