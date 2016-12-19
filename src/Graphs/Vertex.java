package Graphs;

import java.util.ArrayList;

public class Vertex {

    private boolean visited;
    private int Distance;
    private ArrayList<Vertex> Neighbors;

    public Vertex() {
        Distance = 0;
        Neighbors = new ArrayList<Vertex>();
        visited = false;
    }

    public Vertex(int d) {
        Distance = d;
        Neighbors = new ArrayList<Vertex>();
        visited = false;
    }

    public int getDistance() {
        return Distance;
    }

    public ArrayList<Vertex> getNeighbors() {
        return Neighbors;
    }

    public void addNeighbor(Vertex v) {
        Neighbors.add(v);
    }

    public boolean isVisited() { return visited; }

    public void visit() { visited = true; }


}
