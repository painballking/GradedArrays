package Arrays;

import java.util.Scanner;

public class p3{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int[] n = new int[input.nextInt()];
        for(int i=0; i<n.length; i++){
            n[i] = i+1;
        }
        int m = input.nextInt();

        int deleted = 0;
        int index = 0;
        int count = 0;
        while(deleted != n.length-1){
            if(n[index] != 0){
                count++;
                if(count == m){
                    n[index] = 0;
                    deleted++;
                    count = 0;
                    for(int i:n)
                        System.out.print(i+ " ");
                    System.out.println();
                }
                index++;
            }
            else
                index++;
            if(index == n.length){
                index = 0;
            }
        }
    }
}