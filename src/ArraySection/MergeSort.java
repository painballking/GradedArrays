package ArraySection;

import java.util.Arrays;

public class MergeSort {


    public static void merge(int[] array, int start1, int final1, int start2, int final2){
        int[] temp = new int[(final1-start1+1)+(final2-start2+1)];
        int startplace = start1;
        int temppointer = 0;
        while(start1 != final1+1 && start2 != final2+1){
            if(array[start1] > array[start2]){
                temp[temppointer] = array[start2];
                start2++;
                temppointer++;
            }
            else if(array[start2] > array[start1]){
                temp[temppointer] = array[start1];
                start1++;
                temppointer++;
            }
            else{
                temp[temppointer] = array[start1];
                temp[temppointer+1] = array[start2];
                start1++;
                start2++;
                temppointer+=2;
            }
        }
        if(start2 == final2+1){
            for(int i=start1; i<=final1; i++){
                temp[temppointer] = array[i];
                temppointer++;
            }
        }
        else if(start1 == final1+1){
            for(int i=start2; i<=final2; i++){
                temp[temppointer] = array[i];
                temppointer++;
            }
        }
        for(int i=0; i<temp.length; i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println();
        for(int i=0; i<temp.length; i++){
            array[startplace+i] = temp[i];
        }
    }

    public static void split(int[] array, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            split(array, l, m);
            split(array, m+1, r);
            merge(array, l, m, m+1, r);
        }
    }
    public static void main(String args[]) {
        int[] test = {7, 8, 4, 5, 6, 9, 1};
        System.out.println(Arrays.toString(test));
        split(test,0, test.length-1);
        System.out.println(Arrays.toString(test));
    }
}
