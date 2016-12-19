package ArraySection;

import java.util.Arrays;

public class QuickSort {

    public static int partition(int[] array, int a, int b){

        int p = array[a];
        int i = a+1;
        int j = b;

        while(i <= j){
            if(array[i] > p && array[j] < p){
                int store = array[i];
                array[i] = array[j]; array[j] = store;
                i++; j--;
            }
            else if(array[i] <= p){
                i++;
            }
            else if(array[j] >= p){
                j--;
            }
        }
        int store = array[j];
        array[j] = array[a];
        array[a] = store;
        return j;
    }

    public static void quicksort(int[] array, int a, int b){
        if(a < b) {
            int p = partition(array, a, b);
            quicksort(array, a, p-1);
            quicksort(array, p+1, b);
        }
    }

    public static void main(String args[]) {
        int[] test = {3, 5, 2, 7, 4, 1};
        quicksort(test, 0, test.length-1);
        System.out.println(Arrays.toString(test));
    }
}
