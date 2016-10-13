package ArraySection;

import java.util.Arrays;

public class MergeSort {


    public static void merge(int[] array, int start1, int final1, int start2, int final2){
        int[] temp = new int[(start1-final1+1)*2];
        int temppointer = 0;
        while(start1-final1-1 != 0 || start2-final2-1 != 0){
            if(array[start1] > array[start2]){
                System.out.println(temppointer);
                System.out.println(start2);
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
        if(start2-final2-1 == 0){
            for(int i=start1; i<=final1; i++){
                temp[temppointer] = array[i];
                temppointer++;
            }
        }
        else if(start1-final1-1 == 0){
            for(int i=start2; i<=final2; i++){
                temp[temppointer] = array[i];
                temppointer++;
            }
        }
    }

    public static void split(int[] array, int l, int r){
        System.out.println(l +" "+ r);
        if(l < r){
            int m = (l+r)/2;
            split(array, l, m);
            split(array, m+1, r);
            merge(array, l, m, m+1, r);
        }
    }
    public static void main(String args[]) {
        int[] test = {8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(test));
        split(test,0, test.length);
        System.out.println(Arrays.toString(test));
    }
}
