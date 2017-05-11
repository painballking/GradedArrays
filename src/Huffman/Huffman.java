package Huffman;

import java.util.*;

public class Huffman {

    private Tree tree;
    private Map<Character, Integer> table;

    public void makeTable(String s) {

        table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            incrementItem(s.charAt(i));
        }
    }

    public void incrementItem(char c) {

        if (table.containsKey(c)) {
            table.put(c, table.get(c) + 1);
        } else {
            table.put(c, 0);
        }
    }

    public void encode(String s) {
        Queue<Tree> queue = new PriorityQueue<Tree>((x, y) -> x.getRoot().getFrequency() - y.getRoot().getFrequency());
        table.forEach((k, v) -> queue.add(new Tree(v, k)));

        while (queue.size() != 1) {
            Tree temp = new Tree(queue.peek().getRoot().getFrequency(), queue.poll().getRoot().getCharacter());

        }

    }

    public static void main(String[] args) {

    }
}
