package BinarySearchTrees;

public class Node {

    private Node leftNode;
    private Node rightNode;
    private int data;


    public Node( int value, Node x, Node y )
    {
        data = value;
        leftNode = x;
        rightNode = y;
    }

    public Node getRightNodeReference()
    {
        return rightNode;
    }

    public Node getLeftNodeReference()
    {
        return leftNode;
    }
    public void  setRightNodeReference(Node y)
    {
        rightNode = y;
    }

    public void setLeftNodeReference(Node y)
    {
        leftNode = y;
    }

    public int getData()
    {
        return data;
    }
}