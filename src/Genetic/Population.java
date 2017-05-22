package Genetic;

public class Population {

    private Chromosome[] population;
    private float maxFitness;
    private boolean foundSolution;
    private int populationSize;
    private float crossoverRate;
    private float mutationRate;

    public Population() {
        populationSize = 200;
        crossoverRate = (float) .7;
        mutationRate = (float) .001;
    }

    public void init() {

        for (int i = 0; i < population.length; i++) {
            population[i] = new Chromosome();
            population[i].init();
        }
    }

    public Chromosome rouletteWheelSelect() {

        int index;
        while (true) {
            index = (int) (Math.random() * population.length);
                if (Math.random() < population[index].getFitness() / maxFitness) {
                    return population[index];
                }
        }
    }

    public void setPopulationSize(int size) {
        populationSize = size;
    }

    public void setCrossoverRate(double rate) {
        crossoverRate = (float) rate;
    }

    public void setMutationRate(double rate) {
        mutationRate = (float) rate;
    }

    public boolean isFoundSolution() {
        return foundSolution;
    }



    public float getMaxFitness() {
        return maxFitness;
    }

}
