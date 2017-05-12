package Huffman;

import java.util.*;

public class Huffman {

    private static Tree tree;
    private static Map<String, Integer> table;
    private static Map<String, String> codes;

    public static void makeTable(String s) {

        table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            incrementItem(s.substring(i, i+1));
        }
    }

    public static void incrementItem(String s) {

        if (table.containsKey(s)) {
            table.put(s, table.get(s) + 1);
        } else {
            table.put(s, 1);
        }
    }

    public static String encode(String s) {

        Queue<Node> queue = new PriorityQueue<Node>((x, y) -> x.getFrequency() - y.getFrequency());

        makeTable(s);
        table.forEach((k, v) -> queue.add(new Node(v, k)));

        while (queue.size() != 1) {
            makeTrees(queue);
        }

        Node tree = queue.poll();
        Tree.outputTree(tree, 5);
        codes = new HashMap<>();
        for (int i = 0; i < tree.getString().length(); i++) {
            String curString = tree.getString().substring(i, i + 1);
            codes.put(curString, generateCode(curString, tree, new StringBuilder()));
        }

        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String curString = s.substring(i, i + 1);
            encoded.append(codes.get(curString));
        }

        return encoded.toString();
    }

    public static String generateCode(String s, Node t, StringBuilder c) {
        if ( !t.getString().equals(s) ) {
            if (t.getLeftNodeReference() != null && t.getLeftNodeReference().getString().contains(s)) {
                c.append("0");
                generateCode(s, t.getLeftNodeReference(), c);
            } else if (t.getRightNodeReference() != null && t.getRightNodeReference().getString().contains(s)){
                c.append("1");
                generateCode(s, t.getRightNodeReference(), c);
            }
        }
        return c.toString();
    }

    private static void makeTrees(Queue<Node> q) {

        //Make a new root
        Node temp = new Node(getNextFrequency(q), getNextString(q));
        //Set left reference
        temp.setLeftNodeReference(q.poll());
        //Add other junk
        temp.addToFrequency(getNextFrequency(q));
        temp.addToString(getNextString(q));
        //Set right node reference
        temp.setRightNodeReference(q.poll());

        q.add(temp);
    }

    private static int getNextFrequency(Queue<Node> q) {

        return q.peek().getFrequency();
    }

    private static String getNextString(Queue<Node> q) {

        return q.peek().getString();
    }

    public static void main(String[] args) {

        String code = encode("who are you");
        System.out.println(code);
        System.out.printf("%d (%d bytes + %d bits)\n", code.length(), code.length() / 8, code.length() % 8);
    }
}
