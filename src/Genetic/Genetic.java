package Genetic;

import java.util.Scanner;

public class Genetic {

    private boolean verbose;

    public Genetic() {
        verbose = false;
    }

    public void start() {
        Population pop = new Population();

        int count = 0;
        while (!pop.isFoundSolution()) {
            System.out.printf("Gen %d: %f", count, pop.getMaxFitness());

            Population nextGen = new Population();

        }
        System.out.printf("Final gen: ", count);

    }

    public void makeNextGen(Population population) {
    }

    public void setVerbose(boolean val) {
        verbose = val;
    }
}
