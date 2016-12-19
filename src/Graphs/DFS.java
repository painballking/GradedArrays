package Graphs;

import java.util.ArrayList;

public class DFS {

    public ArrayList<Vertex> buildGraph(){
        ArrayList<Vertex> vertices = new ArrayList<>();
        for(int i=0; i<5; i++){
            vertices.add(new Vertex());
        }
        int[][] edges = {{1, 2, 3}, {0, 2, 4}, {0, 1}, {0, 4}, {1, 3}};
        for(int i=0; i<edges.length; i++){
            for(int j : edges[i]){
                vertices.get(i).addNeighbor(vertices.get(j));
            }
        }
        return vertices;
    }

    public static void depthFirstSearch()

    public static void main(String args[]) {

    }
}
