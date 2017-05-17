package Huffman;

import java.util.*;

public class Huffman {

    private Map<String, Integer> table;
    private Map<String, String> codes;

    public Huffman() {
        table = new HashMap<>();
        codes = new HashMap<>();
    }

    private void makeTable(String s) {

        table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            incrementItem(s.substring(i, i+1));
        }
    }

    private void incrementItem(String s) {

        if (table.containsKey(s)) {
            table.put(s, table.get(s) + 1);
        } else {
            table.put(s, 1);
        }
    }

    public String encode(String s) {

        Queue<Node> queue = new PriorityQueue<Node>((x, y) -> x.getFrequency() - y.getFrequency());

        makeTable(s);
        table.forEach((k, v) -> queue.add(new Node(v, k)));

        while (queue.size() != 1) {
            makeTrees(queue);
        }

        Node daBestTree = queue.poll();

        for (int i = 0; i < daBestTree.getString().length(); i++) {
            String curString = daBestTree.getString().substring(i, i + 1);
            codes.put(curString, generateCode(curString, daBestTree, new StringBuilder()));
        }

        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String curString = s.substring(i, i + 1);
            encoded.append(codes.get(curString));
        }

        return encoded.toString();
    }

    public String decode() {
        return "";
    }

    private String generateCode(String s, Node t, StringBuilder c) {
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

    private void makeTrees(Queue<Node> q) {

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

    private int getNextFrequency(Queue<Node> q) {

        return q.peek().getFrequency();
    }

    private String getNextString(Queue<Node> q) {

        return q.peek().getString();
    }

    public void printTable() {
        codes.forEach((k, v) -> System.out.printf("%s: %s\n", k, v));
    }

    public void calculateDecoderBits() {
        int characters = table.size()*8;
        int codeLen = 0;
        for (Map.Entry<String, String> entry : codes.entrySet()) {
            codeLen += entry.getValue().length();
        }

        int total = (table.size() - 1) * 8 + characters + codeLen;
        System.out.printf("%s bits\n", total);
    }
}
