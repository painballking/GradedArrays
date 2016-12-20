package Graphs;

import java.util.ArrayList;

public class Vertex {

    private boolean visited;
    private int Distance;
    private String Name;
    private ArrayList<Vertex> Neighbors;

    public Vertex(String n) {
        Name = n;
        Distance = 0;
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

    public String getName(){ return Name; }
    public void setName(String n) { Name = n; }

    public boolean isVisited() { return visited; }

    public void visit() { visited = true; }


}
