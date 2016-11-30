package VCU_2016;

import java.util.*;

public class Problem_C {

    private static class Node{
        Map<Node, Double> neighbors;
        Double distance;

        private Node(){
            neighbors = new HashMap<>();
            distance = Double.MAX_VALUE;
        }

        private void add(Node neighbor, Double distance){
            if(!neighbors.containsKey(neighbor)){
                neighbors.put(neighbor, distance);
            }
        }

        private void setDist(Double val){
            distance = val;
        }

        private void setDist(Integer val){
            distance = 1.0*val;
        }

        private Double getDistance(){ return distance; }

        private Map<Node, Double> getNeighbors(){ return neighbors; }
        private void setNeighbors(Map<Node, Double> newN){ neighbors = newN; }
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int vertices = input.nextInt();
        int vS = input.nextInt();
        int vF = input.nextInt();

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            nodes.add(new Node());
        }

        for (int i = 0; i < 6; i++) {
            String[] line = input.nextLine().split(" ");
            for (int j = 3; j < line.length; j += 2) {
                nodes.get(Integer.parseInt(line[j])).add(nodes.get(Integer.parseInt(line[j - 2])), Double.parseDouble(line[j - 1]) / Double.parseDouble(line[0]));
                nodes.get(Integer.parseInt(line[j - 2])).add(nodes.get(Integer.parseInt(line[j])), Double.parseDouble(line[j - 1]) / Double.parseDouble(line[0]));
            }
        }

        nodes.get(vS).setDist(0);

        Node minDist = new Node();
        while (nodes.size() != 0) {
            minDist = nodes.get(0);
            for (Node n : nodes) {
                if (n.getDistance() < minDist.getDistance()) {
                    minDist = n;
                }
            }
            nodes.remove(minDist);

            Map<Node, Double> neighbors = minDist.getNeighbors();
            for (Map.Entry<Node, Double> e : neighbors.entrySet()) {
                if (nodes.contains(e.getKey())) {
                    double distance = minDist.getDistance() + e.getValue();
                    if (distance < e.getKey().getDistance()) {
                        e.getKey().setDist(distance);
                    }

                }

            }

        }
        System.out.println(minDist.getDistance());
    }
}
