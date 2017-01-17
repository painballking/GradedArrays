import java.util.Arrays;

public class MajorityValue {

    public static int majorityValue(int[] array){
        int max_sequence_len = 0;
        int max_sequence_val = 0;

        int cur_sequence_length = 1;
        for(int i=1; i<array.length; i++){
            if(array[i] == array[i-1]){
                cur_sequence_length++;
                if(cur_sequence_length > max_sequence_len){
                    max_sequence_len = cur_sequence_length;
                    max_sequence_val = array[i];
                }
            }
            else
                cur_sequence_length = 1;
        }

        int potential_val = max_sequence_len < array.length/2 + 1 && array[0] == array[array.length-1] ? array[0] : max_sequence_val;

        int count = 0;
        for(int i=0; i<array.length; i++)
            if(array[i] == potential_val) count++;

        if(count >= array.length/2 + 1) return potential_val;
        return Integer.MIN_VALUE;
    }

    public static void main(String args[]) {
        int[][] cases = {
                {1, 1, 2, 2, 1},
                {1, 2, 2, 1, 1},
                {1, 1, 1},
                {2, 2, 1, 1, 1, 1},
                {1, 1, 2, 2, 2, 1, 1},
                {1, 1, 2, 2, 3, 3, 1, 1, 3, 3, 1, 1, 3, 1, 1},
                {1, 1, 2, 2, 3, 3, 1, 3, 3, 2, 2, 3, 3, 3, 3},
                {1,2,3},
                {1, 2, 2, 2, 1},
                {1, 2}};
        int[] answers = {1, 1, 1, 1, 1, 1, 3, Integer.MIN_VALUE, 2, Integer.MIN_VALUE};

        for(int i=0; i<cases.length; i++){
            if(answers[i] != majorityValue(cases[i])) {
                System.out.println("Bad: " + (i + 1));
            }
        }
    }
}
