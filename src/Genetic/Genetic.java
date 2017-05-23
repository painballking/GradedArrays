package Genetic;

import java.util.Scanner;

public class Genetic {

    private boolean verbose;
    private float target;

    public Genetic() {
        verbose = false;
    }

    public void start() {
        Population pop = new Population(target);
        pop.init();

        int count = 0;
        while (!pop.isFoundSolution()) {
            if (verbose) {
                System.out.printf("Gen %d: %f\n", count, pop.getMaxFitness());
            }

            Population nextGen = makeNextGen(pop);
            pop = nextGen;
            count++;
        }
        System.out.printf("Final gen: %d", count);

    }

    public Population makeNextGen(Population population) {

        Population nextGen = new Population(target);
        for (int i = 0; i < population.getPopulationSize(); i += 2) {
            Chromosome[] temp = population.getPair(population.rouletteWheelSelect(), population.rouletteWheelSelect());
            nextGen.setPair(i, temp);
        }
        nextGen.test();

        return nextGen;
    }

    public void setVerbose(boolean val) {
        verbose = val;
    }
    public void setTarget(double val) {
        target = (float) val;
    }
    public void setTarget(int val) {
        target = (float) val;
    }
}
