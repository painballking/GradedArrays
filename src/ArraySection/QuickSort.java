package ArraySection;

import java.util.Arrays;

public class QuickSort {

    public static void partition(int[] array, int a, int b){

        int p = array[a];
        int i = 1;
        int j= array.length-1;

        while(i >= j){
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
        array
    }

    public static void main(String args[]) {
        int[] test = {1, 2, 3, 4, 5};
        partition(test);
    }
}
