package BinarySearchTrees;

import java.util.*;

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

    public int getMaxValLevel(Node node){
        if(node.getRightNodeReference() == null){
            return 1;
        }
        else{
            return 1 + getMaxValLevel(node.getRightNodeReference());
        }
    }

    public int getMinValLevel(Node node){
        if(node.getLeftNodeReference() == null){
            return 1;
        }
        else{
            return 1 + getMinValLevel(node.getLeftNodeReference());
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

    public boolean hasChildren(Node node){
        return (node.getLeftNodeReference() != null || node.getRightNodeReference() != null);
    }

    public boolean isComplete(Node node){
        List<Node> list = new ArrayList<>();

        list.add(node);
        while(!list.contains(null)){
            int max = list.size();
            for(int i=0; i<max; i++){
                list.add(list.get(i).getLeftNodeReference());
                list.add(list.get(i).getRightNodeReference());
            }
            for(int i=0; i<max; i++){
                list.remove(0);
            }
            boolean flag = false;
            for(int i=0; i<list.size(); i++){
                if(flag && list.get(i) != null){
                    return false;
                }
                else if(list.get(i) == null){
                    flag = true;
                }
            }
        }
        for(int i=0; i<list.size(); i++){
            if(list.get(i) != null && hasChildren(list.get(i))){
                return false;
            }
        }
        return true;
    }

    public int highestCostPath(Node node){
        if(!hasChildren(node)){
            return node.getData();
        }
        else if(node.getRightNodeReference() == null){
            return node.getData() + highestCostPath(node.getLeftNodeReference());
        }
        else if(node.getLeftNodeReference() == null){
            return node.getData() + highestCostPath(node.getRightNodeReference());
        }
        else{
            return node.getData() + Math.max(highestCostPath(node.getLeftNodeReference()),
                                                highestCostPath(node.getRightNodeReference()));
        }
    }

    public int longestPath(Node node){
        Queue<Node> q = new LinkedList();
        q.add(node);

        int max = -1;

        while(q.peek() != null){
            Node working = q.element();

            if(working.getLeftNodeReference() == null){
                int temp = 1 + treeHeight(working.getRightNodeReference());
                max = temp > max ? temp : max;
                q.add(working.getRightNodeReference());
            }
            else if(working.getRightNodeReference() == null){
                int temp = 1 + treeHeight(working.getLeftNodeReference());
                max = temp > max ? temp : max;
                q.add(working.getLeftNodeReference());
            }
            else{
                int temp = 1 +  treeHeight(working.getLeftNodeReference()) +
                                treeHeight(working.getRightNodeReference());
                max = temp > max ? temp : max;
                q.add(working.getRightNodeReference());
                q.add(working.getLeftNodeReference());
            }
            q.poll();
        }
        return max;
    }

    public int[] nextPerm(int[] array){
        for(int k=array.length - 2; k >= 0; k--){
            if(array[k] < array[k+1]){
                for(int i=array.length - 1; i > k; i--){
                    if(array[k] < array[i]){
                        int store = array[i];
                        array[i] = array[k];
                        array[k] = store;
                        //for(int j=1;);
                    }
                }
            }
        }
        return array;
    }

    public void distinctTrees(int n){
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = i;
        }
        do{
            System.out.println(Arrays.toString(array));
            array = nextPerm(array);
        }while(array != nextPerm(array));
    }
}

