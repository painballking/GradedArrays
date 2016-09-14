import java.util.Scanner;

public class p3{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
//        int[] n = new int[input.nextInt()];
        int[] n = new int[6];
        for(int i=0; i<n.length; i++){
            n[i] = i+1;
        }
        //int m = input.nextInt();
        int m = 5;

        int deleted = 0;
        int count;
        int index = 0;

        while(deleted != n.length-1){
            count = 1;
            while(count != m){
                if(n[index] != 0){
                    count++;
                    index++;
                }
                while(index != n.length && n[index] == 0){
                    index++;
                }
                if(index == n.length){
                    index = 0;
                }
            }
            n[index] = 0;
            deleted++;
            for(int i:n)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}