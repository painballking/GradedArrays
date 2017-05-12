package Huffman;

public class Node {

    private Node leftNode;
    private Node rightNode;
    private int frequency;
    private String string;

    public Node(int f, String s) {
        frequency = f;
        string = s;
    }

    public Node getRightNodeReference() {
        return rightNode;
    }
    public Node getLeftNodeReference() {
        return leftNode;
    }
    public void  setRightNodeReference(Node n) {
        rightNode = n;
    }
    public void setLeftNodeReference(Node n) {
        leftNode = n;
    }

    public int getFrequency() {
        return frequency;
    }
    public String getString() {
        return string;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setString(String string) {
        this.string = string;
    }

    public void addToString(String s) {
        this.string += s;
    }

    public void addToFrequency(int f) {
        this.frequency += f;
    }
}