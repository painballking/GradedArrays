package BinaryHeaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryHeap {

    public static int[] heapify(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            if ((i + 1) * 2 >= array.length || i * 2 + 1 >= array.length) {
                if ((i + 1) * 2 >= array.length && array[i * 2 + 1] < array[i]) {
                    int store = array[i * 2 + 1];
                    array[i * 2 + 1] = array[i];
                    array[i] = store;
                } else if (i * 2 + 1 >= array.length && array[(i * 2) + 1] < array[i]) {
                    int store = array[(i + 1) * 2];
                    array[(i + 1) * 2] = array[i];
                    array[i] = store;
                }
                break;
            } else {
                if (array[(i + 1) * 2] < array[i] || array[i * 2 + 1] < array[i]) {
                    int child = array[(i + 1) * 2] < array[i * 2 + 1] ? (i + 1) * 2 : i * 2 + 1;
                    int store = array[child];
                    array[child] = array[i];
                    array[i] = store;
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

    public static class Heap {

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
