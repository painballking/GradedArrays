package ArraySection;

public class MajorityValue {

    public static void main(String args[]) {
        int value = Integer.MAX_VALUE;

        int[] d = {1, 1, 2, 2, 1};  // 1
        int[] e = {2, 2, 1, 1, 1};  // 1
        int[] array = d;

        int count = 0;
        int potential = 0;
        int pairs = 0;
        int unique = 0;
        for(int i=1; i<array.length; i++){
            if(array[i] == array[i-1]) pairs++;
        }


    }
}
