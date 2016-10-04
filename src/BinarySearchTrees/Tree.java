package BinarySearchTrees;

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }


    public void insert(int value, Node x) {
        if (x == null) {
            root = new Node(value, null, null);
        } else {
            if (value < x.getData()) {
                if (x.getLeftNodeReference() == null) {
                    Node y = new Node(value, null, null);
                    x.setLeftNodeReference(y);
                } else {
                    insert(value, x.getLeftNodeReference());
                }
            } else {
                if (x.getRightNodeReference() == null) {
                    Node y = new Node(value, null, null);
                    x.setRightNodeReference(y);
                } else {
                    insert(value, x.getRightNodeReference());
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
            System.out.println(currentNode.getData());
            outputTree(currentNode.getLeftNodeReference(), spaces + 5);
        }
    }

    public void getMinumumValue(Node node) {
        if (node.getLeftNodeReference() == null) {
            System.out.println(node.getData());
        } else {
            getMinumumValue(node.getLeftNodeReference());
        }
    }

    public void getMaximumValue(Node node) {
        if (node.getRightNodeReference() == null) {
            System.out.println(node.getData());
        } else {
            getMaximumValue(node.getRightNodeReference());
        }
    }

    public void printLeaves(Node node) {
        if (node.getLeftNodeReference() == null && node.getRightNodeReference() == null) {
            System.out.println(node.getData());
        } else if (node.getRightNodeReference() == null) {
            printLeaves(node.getLeftNodeReference());
        } else if (node.getLeftNodeReference() == null) {
            printLeaves(node.getRightNodeReference());
        } else {
            printLeaves(node.getRightNodeReference());
            printLeaves(node.getLeftNodeReference());
        }
    }

    public boolean findValue(int search, Node node) {
        if (node == null) {
            return false;
        } else {
            if (search > node.getData()) {
                return findValue(search, node.getRightNodeReference());
            } else if (search < node.getData()) {
                return findValue(search, node.getLeftNodeReference());
            } else {
                return true;
            }
        }
    }

    public int treeHeight(Node node) {
        if(node == null){
            return 0;
        }
        else if(node.getRightNodeReference() == null){
            return 1 + treeHeight(node.getLeftNodeReference());
        }
        else if(node.getLeftNodeReference() == null){
            return 1 + treeHeight(node.getRightNodeReference());
        }
        else{
            return 1 + Math.max(treeHeight(node.getLeftNodeReference()),
                                treeHeight(node.getRightNodeReference()));
        }
    }

    public int valueHeight(int search, Node node){
        if(!findValue(search, node)){
            return -1;
        }
        if (search > node.getData()) {
            return 1 + valueHeight(search, node.getRightNodeReference());
        } else if (search < node.getData()) {
            return 1 + valueHeight(search, node.getLeftNodeReference());
        } else {
            return 1;
        }
    }

    public void path(int value, Node node){
        if (value > node.getData()) {
            System.out.print(node.getData() + " ");
            path(value, node.getRightNodeReference());
        } else if (value < node.getData()) {
            System.out.print(node.getData() + " ");
            path(value, node.getLeftNodeReference());
        } else {
            System.out.print(value);
        }
    }

    public boolean isComplete(Node node){

    }

}
