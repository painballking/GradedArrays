import java.util.*;

public class safe {
    public static void main(String[] args) {
        int n,p,q,j,k;
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            n=in.nextInt();
            p=in.nextInt();
            q=in.nextInt();
            j=in.nextInt();
            k=in.nextInt();
            if(n==0 && p ==0 && q == 0 && j ==0 && k ==0)
                break;
            System.out.println(safe(n,p,q,j,k));
        }
    }
    public static int safe(int n, int p, int q, int j, int k) {
        if ( j >=n || j <0) return 0;
        else if ( k == 0 && j >= p && j <= q ) return 1;
        else if (k == 0) return 0;
        else return safe(n,p,q,j+1,k-1) + safe(n,p,q,j-1,k-1);
    }
}
