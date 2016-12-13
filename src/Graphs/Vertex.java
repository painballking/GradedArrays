package Graphs;

import java.util.ArrayList;

public class Vertex {

    private int Distance;
    private ArrayList<Vertex> Neighbors;

    public Vertex() {
        Distance = 0;
        Neighbors = new ArrayList<Vertex>();
    }

    public Vertex(int d) {
        Distance = d;
        Neighbors = new ArrayList<Vertex>();
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


}
