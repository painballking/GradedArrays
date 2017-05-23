package Genetic;

public class Population {

    private Chromosome[] population;
    private float maxFitness;
    private int populationSize;
    private float crossoverRate;
    private float mutationRate;
    private float target;

    public Population(float target) {
        populationSize = 200;
        crossoverRate = (float) .7;
        mutationRate = (float) .001;
        population = new Chromosome[populationSize];
        this.target = target;
        maxFitness = 0;
    }

    public void init() {

        for (int i = 0; i < population.length; i++) {
            population[i] = new Chromosome();
        }
        test();
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

    public Chromosome[] getPair(Chromosome p1, Chromosome p2) {

        StringBuilder child1 = new StringBuilder();
        StringBuilder child2 = new StringBuilder();

        if (Math.random() < crossoverRate) {

            int split = (int) (Math.random() * p1.getChromosomeSize());
            child1.append(p1.getLeftSplit(split));
            child1.append(p2.getRightSplit(split));

            child2.append(p2.getLeftSplit(split));
            child2.append(p1.getRightSplit(split));

        } else {
            child1.append(p1.getChromosome());
            child2.append(p2.getChromosome());
        }

        for (int i = 0; i < p1.getChromosomeSize(); i++) {
            if (Math.random() < mutationRate) {
                if (child1.charAt(i) == '0') {
                    child1.setCharAt(i, '1');
                } else {
                    child1.setCharAt(i, '0');
                }
            }

            if (Math.random() < mutationRate) {
                if (child2.charAt(i) == '0') {
                    child2.setCharAt(i, '1');
                } else {
                    child2.setCharAt(i, '0');
                }
            }
        }

        return new Chromosome[]{new Chromosome(child1.toString()), new Chromosome(child2.toString())};
    }

    public void test() {

        for (int i = 0; i < populationSize; i++) {
            population[i].update(target);
            if (population[i].getFitness() > maxFitness) maxFitness = population[i].getFitness();
        }
    }

    public void setPopulationSize(int size) {
        populationSize = size;
        population = new Chromosome[populationSize];
    }

    public void setCrossoverRate(double rate) {
        crossoverRate = (float) rate;
    }

    public void setMutationRate(double rate) {
        mutationRate = (float) rate;
    }

    public boolean isFoundSolution() {
        return Float.isInfinite(maxFitness);
    }

    public void setPair(int index, Chromosome[] pair) {
        population[index] = pair[0];
        population[index + 1] = pair[1];
    }

    public float getMaxFitness() {

        return maxFitness;
    }

    public int getPopulationSize() {
        return populationSize;
    }

}
