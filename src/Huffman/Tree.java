package Huffman;

public class Tree {
    private Node root;

    public Tree(int frequency, String string) {
        root = new Node(frequency, string);
    }
    public Tree(Node root) {
        this.root = root;
    }

    public void insert(int frequency, String string, Node x) {
        if (x == null) {
            root = new Node(frequency, string);
        } else {
            if (frequency < x.getFrequency()) {
                if (x.getLeftNodeReference() == null) {
                    Node y = new Node(frequency, string);
                    x.setLeftNodeReference(y);
                } else {
                    insert(frequency, string, x.getLeftNodeReference());
                }
            } else {
                if (x.getRightNodeReference() == null) {
                    Node y = new Node(frequency, string);
                    x.setRightNodeReference(y);
                } else {
                    insert(frequency, string, x.getRightNodeReference());
                }
            }
        }
    }

    public static void outputTree(Node currentNode, int spaces) {
        if (currentNode == null) {
            return;
        } else {
            outputTree(currentNode.getRightNodeReference(), spaces + 5);
            for (int k = 1; k <= spaces; k++) {
                System.out.print(" ");
            }
            System.out.println(currentNode.getString() + ": " + currentNode.getFrequency());
            outputTree(currentNode.getLeftNodeReference(), spaces + 5);
        }
    }

    public Node getRoot() {
        return root;
    }

}

