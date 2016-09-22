package Strings;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class p5 {
    public static void main(String args[]) {
        String input1 = "brillig and the wabe troves did gimble in gyre";
        String input2 = "twas and the slithy troves did gimble wabe";
//        String input1 = "dotes dozy iddle amzy divvy";
//        String input2 = "marzy dotes dozy amzy divvy";

        String[] in1 = input1.split(" ");
        String[] in2 = input2.split(" ");

        List<String> common = new ArrayList<String>();
        if(in1.length > in2.length){
            for(int i=0; i<in2.length; i++){
                if(asList(in1).contains(in2[i])){
                    common[i] = in2[i];
                }
            }
        }

    }
}
