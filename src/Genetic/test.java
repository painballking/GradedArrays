package Genetic;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class test {
    public static void main(String[] args) {

        Chromosome c = new Chromosome("110101100111000001001010011001000010");
        float k = c.evaluate();
        c.printFunction();

        System.out.println(k);
    }
}
