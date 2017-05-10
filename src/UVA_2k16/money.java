package UVA_2k16;
import java.util.*;

public class money {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        int max = 1;
        for(int i=1; i <= s.length(); i++){
            String base = s.substring(0, s.length()/i);

            boolean flag = false;
            for(int j=1; j < i; j++){
                if(!base.equals(s.substring(s.length()/i*j, s.length()/i*j + s.length()/i))){
                    flag = true;
                }
                if(flag) break;
            }
            if(s.length()%i != 0) flag = true;
            if(!flag && i > max) max = i;
        }
        System.out.println(max);
    }
}
