package Huffman;

public class Node {

    private Node leftNode;
    private Node rightNode;
    private int frequency;
    private char character;

    public Node(int f, char c) {
        frequency = f;
        character = c;
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
    public char getCharacter() {
        return character;
    }
}