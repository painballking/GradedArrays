package Genetic;

import java.util.BitSet;

public class Chromosome {

    private final static int CHROMOSOME_SIZE = 36;
    private BitSet chromosome;

    public Chromosome() {

        chromosome = new BitSet(CHROMOSOME_SIZE);
        for (int i = 0; i < chromosome.length(); i++) {
            if (Math.random() < .5) {
                chromosome.flip(i);
            }
        }
    }
}
