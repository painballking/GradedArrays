package UVA_2016;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int kek = scan.nextInt();
        scan.nextLine();
        for(int i=0; i<kek; i++){
            String[] line = scan.nextLine().split(" ");
            Map<Integer, Integer> menu = new HashMap<>();
            for(int j=0; j<Integer.parseInt(line[0]); j++){
                menu.put(j+1, scan.nextInt());
            }
            int sum = 0;
            for(int j=0; j<Integer.parseInt(line[1]); j++){
                sum += menu.get(scan.nextInt());
            }
            double tip = Integer.parseInt(line[2]);
            double num = (int)(sum*(100+tip)/100+0.9)/100.0;
            System.out.format("Case %d: $%.2f\n", i+1, num);
            scan.nextLine();
        }
    }
}

