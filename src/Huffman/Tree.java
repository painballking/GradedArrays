package Huffman;

public class Tree {
    private Node root;

    public Tree(int frequency, char character) {
        root = new Node(frequency, character);
    }

    public void insert(int frequency, char character, Node x) {
        if (x == null) {
            root = new Node(frequency, character);
        } else {
            if (frequency < x.getFrequency()) {
                if (x.getLeftNodeReference() == null) {
                    Node y = new Node(frequency, character);
                    x.setLeftNodeReference(y);
                } else {
                    insert(frequency, character, x.getLeftNodeReference());
                }
            } else {
                if (x.getRightNodeReference() == null) {
                    Node y = new Node(frequency, character);
                    x.setRightNodeReference(y);
                } else {
                    insert(frequency, character, x.getRightNodeReference());
                }
            }
        }
    }

    public void outputTree(Node currentNode, int spaces) {
        if (currentNode == null) {
            return;
        } else {
            outputTree(currentNode.getRightNodeReference(), spaces + 5);
            for (int k = 1; k <= spaces; k++) {
                System.out.print(" ");
            }
            System.out.println(currentNode.getCharacter() + ": " + currentNode.getFrequency());
            outputTree(currentNode.getLeftNodeReference(), spaces + 5);
        }
    }

    public Node getRoot() {
        return root;
    }

}

