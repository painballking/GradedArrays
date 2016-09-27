package LinkedLists;

public class Node {
    private int data;
    private Node next;

    public Node (int value, Node ref) {
        data = value;
        next = ref;
    }

    public int getData() {
        return data;
    }

    public Node getNextReference() {
        return next;
    }

    public void setNextReference(Node value) {
        next = value;
    }
}
