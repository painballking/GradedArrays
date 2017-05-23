package Genetic;

public class Runner {
    public static void main(String[] args) {
        Genetic g = new Genetic();
        g.setTarget(12);
        g.setVerbose(true);

        g.start();
    }
}
