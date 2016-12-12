package BinaryHeaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryHeap {

    public static class Heap{

        private ArrayList<Integer> heap;

        public Heap(){ heap = new ArrayList<>(); }
        public Heap(List<Integer> heap){
            heap = heap;
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

        public int pop(){
            int temp = heap.get(0);
            heap.set(0, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);

            //Percolation Group
            int p = 0; //Pointer to percolated
            while( (p+1)*2 < heap.size() || p*2+1 < heap.size() ){

                if ( (p+1)*2 >= heap.size() || p*2+1 >= heap.size()) {
                    if((p+1)*2 >= heap.size() && heap.get(p*2+1) < heap.get(p)) {
                        int store = heap.get(p*2+1);
                        heap.set(p*2+1, heap.get(p));
                        heap.set(p, store);
                    }
                    else if(p+1*2 >= heap.size() && heap.get((p*2)+1) < heap.get(p)) {
                        int store = heap.get((p + 1) * 2);
                        heap.set((p + 1) * 2, heap.get(p));
                        heap.set(p, store);
                    }
                    break;
                }
                else {
                    if (heap.get((p+1)*2) < heap.get(p) || heap.get(p*2+1) < heap.get(p)) {
                        int child = heap.get((p+1)*2) < heap.get(p*2+1) ? (p+1)*2 : p*2+1;
                        int store = heap.get(child);
                        heap.set(child, heap.get(p));
                        heap.set(p, store);
                        p = child;
                    }
                    else{
                        break;
                    }
                }
            }

            return temp;
        }
    }

    public static ArrayList<Integer> heapify(ArrayList<Integer> list){
        for(int i=(list.size()-2)/2; i>=0; i++){
            break;
        }
        return list;
    }

    public static void setHeap(ArrayList<Integer> heap){
        heap = heap;
    }

    public static void main(String args[]){
        int[] array = {5, 7, 10, 9, 11, 21};
    }
}
