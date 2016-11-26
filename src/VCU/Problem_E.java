package VCU;

import java.util.Scanner;

public class Problem_E {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        String p1 = input.nextLine();
        String p2 = input.nextLine();

        int count = 0;
        for(int i=0; i<p1.length(); i++) {
            if (p1.charAt(i) == p2.charAt(i))
                count++;
        }
        System.out.println(count + "/" + p1.length());
    }
}
