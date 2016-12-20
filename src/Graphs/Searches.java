package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Searches {

    public static ArrayList<Vertex> buildGraph(){
        ArrayList<Vertex> nodes = new ArrayList<>();
        nodes.add(new Vertex("V0"));
        nodes.add(new Vertex("V1"));
        nodes.add(new Vertex("V2"));
        nodes.add(new Vertex("V3"));
        nodes.add(new Vertex("V4"));

        int[][] neighbors = {{1, 2, 3}, {0, 2, 4}, {0, 1}, {0, 4}, {1, 3}};
        for(int i=0; i<neighbors.length; i++){
            for(int j : neighbors[i])
                nodes.get(i).addNeighbor(nodes.get(j));
        }

        return nodes;
    }

    public static void depthFirstSearch(Vertex v){
        System.out.println("Found: " + v.getName());
        v.visit();

        for(Vertex V : v.getNeighbors())
            if(!V.isVisited())
                depthFirstSearch(V);
    }

    public static void breadthFirstSearch(Vertex v){
        Queue<Vertex> q = new LinkedList<>();
        List<String> visited = new ArrayList<>();
        q.add(v);

        while(q.size() > 0){
            System.out.println("Found: " + q.peek().getName());
            visited.add(q.peek().getName());

            for(Vertex V : q.peek().getNeighbors()){
                if(!visited.contains(V.getName())){
                    q.add(V);
                    visited.add(V.getName());
                }
            }
            q.poll();
        }


    }

    public static void main(String args[]) {
        ArrayList<Vertex> graph = buildGraph();
        breadthFirstSearch(graph.get(0));
    }
}
