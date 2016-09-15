public class SelectionSort {
    public static void main(String args[]) {
        int[] array = {6,8,7,3,9,2,4,1,5};

        int min;
        int store;
        for(int i=0; i<array.length; i++){
            min = i;
            for(int j=i; j<array.length; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            store = array[i];
            array[i] = array[min];
            array[min] = store;

            for(int x:array)
                System.out.print(x+" ");
            System.out.println();
        }
    }
}
