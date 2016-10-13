package ArraySection;

public class BubbleSort {
    public static void main(String args[]) {
        int[] array = {6,8,7,3,9,2,4,1,5};

        boolean swapped = true;
        int store;
        while(swapped != false){
            swapped = false;
            for(int i=0; i<array.length-1; i++){
                if(array[i+1] < array[i]){
                    store = array[i];
                    array[i] = array[i+1];
                    array[i+1] = store;
                    swapped = true;
                    for(int x:array)
                        System.out.print(x+" ");
                    System.out.println();
                }
            }
        }
    }
}
