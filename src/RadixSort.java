public class RadixSort {

    public static int maxNumLen(int[] array){
        int max = array[0];
        for(int i: array){
            if(i>max)
                max = i;
        }
        int count = 0;
        while(max>0){
            max/=10;
            count++;
        }
        return count;
    }

    public static void main(String args[]) {
        int[] array = {859, 99, 595, 221, 694, 190, 409, 918, 952, 1};
        int[] copy = new int[array.length];
        int[] nums = new int[10];

        int loopLen = maxNumLen(array);
        for(int x=0; x<loopLen; x++){
            for(int i:nums)
                i = 0;
            for(int i:array){
                nums[i%(int)(Math.pow(10,1+i))]++;
            }
            for(int i=0; i<nums.length-1;i++){
                nums[i+1] += nums[i];
            }
            for(int i=array.length-1; i>-1; i++){

            }
        }

    }
}
