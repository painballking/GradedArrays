package BinaryHeaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryHeap {

    public static int[] heapify(int[] array) {
        for (int parent = (array.length - 1) / 2; parent >= 0; parent--) {

            int leftChild = (parent+1)*2;
            int rightChild = parent*2+1;

            if (leftChild >= array.length || rightChild >= array.length) {
                if (leftChild >= array.length && array[rightChild] < array[parent]) {
                    int store = array[rightChild];
                    array[rightChild] = array[parent];
                    array[parent] = store;
                } else if (rightChild >= array.length && array[leftChild] < array[parent]) {
                    int store = array[leftChild];
                    array[leftChild] = array[parent];
                    array[parent] = store;
                }
            } else {
                if (array[leftChild] < array[parent] || array[rightChild] < array[parent]) {
                    int child = array[leftChild] < array[rightChild] ? leftChild : rightChild;
                    int store = array[child];
                    array[child] = array[parent];
                    array[parent] = store;
                }
            }
        }
        return array;
    }

    public static void main(String args[]) {
        int[] array = {21, 11, 9, 10, 7, 5};
        array = heapify(array);
        Heap myHeap = new Heap();
        for (int i : array) {
            myHeap.insert(i);
        }
        myHeap.print();
    }

    static class Heap {

        private ArrayList<Integer> heap;

        public Heap() {
            heap = new ArrayList<>();
        }

        public Heap(List<Integer> heap) {
            heap = new ArrayList<Integer>(heap);
        }

        public void insert(int value) {
            heap.add(value);
            int current_cell = heap.size() - 1;
            while (current_cell != 0 && heap.get((current_cell - 1) / 2) > heap.get(current_cell)) {
                swap((current_cell - 1) / 2, current_cell);
                current_cell = (current_cell - 1) / 2;
            }
        }

        public void swap(int index1, int index2) {
            int store = heap.get(index1);
            heap.set(index1, heap.get(index2));
            heap.set(index2, store);
        }

        public void print() {
            System.out.println(Arrays.toString(heap.toArray()));
        }

        public int pop() {
            int temp = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int p = 0;
            while ((p + 1) * 2 < heap.size() || p * 2 + 1 < heap.size()) {

                int leftChild = p * 2 + 1;
                int rightChild = (p + 1) * 2;

                if (leftChild >= heap.size() || rightChild >= heap.size()) {

                    if (leftChild >= heap.size() && heap.get(rightChild) < heap.get(p)) {
                        swap(rightChild, p);
                    } else if (rightChild >= heap.size() && heap.get(leftChild) < heap.get(p)) {
                        swap(leftChild, p);
                    }
                    break;
                } else {
                    if (heap.get(leftChild) < heap.get(p) || heap.get(rightChild) < heap.get(p)) {
                        int child = heap.get(leftChild) < heap.get(rightChild) ? leftChild : rightChild;
                        swap(child, p);
                        p = child;
                    } else {
                        break;
                    }
                }
            }
            return temp;
        }
    }
}
