package BinaryHeaps;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryHeap {
    static LinkedList<Integer> heap = new LinkedList<>();

    static public void insert(int value){
        heap.add(value);
        int current_cell = heap.size()-1;
        while(current_cell != 0 && heap.get((current_cell-1)/2) > heap.get(current_cell)){
            int parent_val = heap.get((current_cell-1)/2);
            heap.set((current_cell-1)/2, heap.get(current_cell));
            heap.set(current_cell, parent_val);
            current_cell = (current_cell-1)/2;
        }
    }

    static public void print(LinkedList list){
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void main(String args[]){
        int[] array = {2,4,11,15,16,18};
        for(int i:array){
            heap.add(i);
        }
        print(heap);
        insert(1);
        print(heap);
    }
}
