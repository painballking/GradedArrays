package BinaryHeaps;

import java.util.*;

public class BinaryHeap {

    public static class Heap{

        List<Integer> heap;

        public Heap(){
            heap = new ArrayList<Integer>();
        }

        public void insert(int value){
            heap.add(value);
            int current_cell = heap.size()-1;
            while(current_cell != 0 && heap.get((current_cell-1)/2) > heap.get(current_cell)){
                int parent_val = heap.get((current_cell-1)/2);
                heap.set((current_cell-1)/2, heap.get(current_cell));
                heap.set(current_cell, parent_val);
                current_cell = (current_cell-1)/2;
            }
        }

        public void print(){
            System.out.println(Arrays.toString(heap.toArray()));
        }
    }

    public static void main(String args[]){
        int[] array = {2,4,11,15,16,18};
        Heap heap = new Heap();
        for(int i:array){
            heap.insert(i);
        }
        heap.print();
    }
}
