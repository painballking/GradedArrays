package ArraySection;

public class InsertionSort {
    public static void main(String args[]) {
        int[] array = {6, 8, 7, 3, 9, 2, 4, 1, 5};

        int num;
        int index;
        for(int i=1; i<array.length; i++){
            num = array[i];
            if(array[i-1] > num){
                boolean nan = true;
                for(int j=i; j>=1; j--){
                    array[j] = array[j-1];
                    if(array[j-1] < num){
                        array[j] = num;
                        nan = false;
                        break;
                    }
                }
                if(nan)
                    array[0] = num;
            }
            for(int x:array)
                System.out.print(x+" ");
            System.out.println();
        }
    }
}
