package BinaryHeaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryHeap {

    public static class Heap{

        private List<Integer> heap;

        public Heap(){ heap = new ArrayList<>(); }

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

        public int pop(){
            int temp = heap.get(0);
            heap.set(0, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            return temp;
        }
    }

    public static void main(String args[]){
        int[] array = {2,4,11,15,16,18};
        Heap myHeap = new Heap();
        for(int i:array){
            myHeap.insert(i);
        }
        myHeap.print();
        myHeap.insert(7);
        myHeap.print();
        myHeap.insert(12);
        myHeap.print();
    }
}
