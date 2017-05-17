package Genetic;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Chromosome {

    private final static int CHROMOSOME_SIZE = 36;
    private String chromosome;

    public Chromosome() {

        StringBuilder temp = new StringBuilder(CHROMOSOME_SIZE);
        for (int i = 0; i < CHROMOSOME_SIZE; i++) {
            if (Math.random() < .5) {
                temp.append("0");
            } else {
                temp.append("1");
            }
        }

        chromosome = temp.toString();
    }

    public float evaluate() {

        //Parse chromosme data
        List<String> sequence = new ArrayList<>();
        boolean getInt = true;
        for (int i = 0; i < CHROMOSOME_SIZE; i+= 4) {

            String gene = chromosome.substring(i, i+4);

            int geneVal = getIntegerValue(gene);
            if (geneVal < 10 && getInt) {
                sequence.add(Integer.toString(geneVal));
                getInt = false;
            } else if (geneVal >= 10 && geneVal < 14 && !getInt) {
                switch (gene) {
                    case "1010":
                        sequence.add("+");
                        break;
                    case "1011":
                        sequence.add("-");
                        break;
                    case "1100":
                        sequence.add("*");
                        break;
                    case "1101":
                        sequence.add("/");
                        break;
                }
                getInt = true;
            }

        }
        //Remove last val if it's a hanging operator
        if ("+-*/".contains(sequence.get(sequence.size() - 1))) {
            sequence.remove(sequence.size() - 1);
        }

        //Evaluate multiplication and division
        for (int i = 0; i < sequence.size(); i++) {
            String cur = sequence.get(i);

            if ("*/".contains(cur)) {

                Float operand2 = getVal(sequence.remove(i + 1));
                Float operand1 = getVal(sequence.remove(i - 1));

                float result;
                if (cur.equals("*")) {
                    result = operand1 + operand2;
                } else {
                    result = operand1 - operand2;
                }

                sequence.set(i - 1, Float.toString(result));
                i--;

            }
        }

        // Evaluate addition and subtraction
        for (int i = 0; i < sequence.size(); i++) {
            String cur = sequence.get(i);

            if ("+-".contains(cur)) {
                Float operand2 = getVal(sequence.remove(i + 1));
                Float operand1 = getVal(sequence.remove(i - 1));

                float result;
                if (cur.equals("+")) {
                    result = operand1 + operand2;
                } else {
                    result = operand1 - operand2;
                }

                sequence.set(i - 1, Float.toString(result));
                i--;
            }
        }

        if(sequence.size() == 0) return 0;
        return Float.parseFloat(sequence.get(0));
    }

    private int getIntegerValue(String gene) {
        return Integer.parseInt(gene, 2);
    }

    private Float getVal(String gene) {
        return Float.parseFloat(gene);
    }
}
