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
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int vertices = input.nextInt();
        int vS = input.nextInt();
        int vF = input.nextInt();

        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<vertices; i++){
            nodes.add(new Node());
        }

        for(int i=0; i<5; i++){
            String[] line = input.nextLine().split(" ");
            for(int j=3; j<line.length; j+=2){
                nodes.get(j).add(nodes.get(Integer.parseInt(line[j-2])), Double.parseDouble(line[j-1])/Double.parseDouble(line[0]));
                nodes.get(j-2).add(nodes.get(Integer.parseInt(line[j])), Double.parseDouble(line[j-1])/Double.parseDouble(line[0]));
            }
        }
        nodes.get(vS).setDist(0);

        Node current = nodes.get(vS);

        while(nodes.size() != 0){

        }

}
