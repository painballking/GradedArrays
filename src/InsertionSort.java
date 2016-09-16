public class InsertionSort {
    public static void main(String args[]) {
        int[] array = {6,8,7,3,9,2,4,1,5};

        int num;
        for(int i=1; i<array.length; i++){
            num = array[i];
            for(int j=i-1; j!=0; j--){
                if(array[j] > num){
                    array[j+1] = array[j];
                }
                else{

                }
            }
            for(int x:array)
                System.out.print(x+" ");
            System.out.println();
        }
    }
}
