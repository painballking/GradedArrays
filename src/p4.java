public class p4 {

    public static int[] subtract(int[] n1, int[] n2){
        for(int i=0; i<n2.length; i++){
            if(n1[i] < n2[i]){
                n1[i+1]--;
                n1[i] = n1[i]+10-n2[i];
            }
            else{
                n1[i] -= n2[i];
            }
        }
        return n1;
    }

    public static int[] multiply(int[] n1, int[] n2){

        int[] prod = new int[2*n1.length];
        for(int i:prod)
            i = 0;

        for(int i=0; i<n2.length; i++){
            for(int j=0; j<n1.length; j++){
                prod[i+j] += n2[i]*n1[j];
            }
        }

        int place;
        int kek;
        for(int i=0; i<prod.length; i++){
            place = 1;
            kek = prod[i] % 10;
            while(prod[i] > 10){
                prod[i] /= 10;
                prod[i+place] += prod[i] % 10;
                place++;
            }
            prod[i] = kek;
        }
        int[] ret = new int[prod.length];
        for(int i=0; i<ret.length; i++){
            ret[ret.length-1-i] = prod[i];
        }
        return ret;
    }
    public static void main(String args[]) {
        //int[] num1 = {4, 9, 0, 2, 8, 1, 7, 2, 6, 3, 7, 4, 8, 5, 0, 2, 8, 8, 3, 1};
        //int[] num2 = {8, 4, 9, 2, 7, 1, 6, 5, 8, 0, 9, 8, 7, 2, 6, 3, 1, 5, 2, 4};
        //Sub ans = 35 898 993 172 387 602 693
        int[] num1 = {4,2,9,5,7,2,0,0,9,1};
        int[] num2 = {8,5,9,5,6,8,2,1,0,3};
        //Multiplication ans = 36 924 644 305 706 231 373

        if (num1.length == num2.length) {
            for (int i = 0; i < num1.length; i++) {
                if (num1[i] > num2[i])
                    break;
                else if (num2[i] > num1[i]) {
                    int[] temp = num1;
                    num1 = num2;
                    num2 = temp;
                    break;
                }
            }
        } else if (num1.length < num2.length) {
            int[] temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int[] n1 = new int[num1.length];
        for (int i = 0; i < num1.length; i++) {
            n1[n1.length - i - 1] = num1[i];
        }
        int[] n2 = new int[num2.length];
        for(int i=0; i<num2.length; i++){
            n2[n2.length - i - 1] = num2[i];
        }

        int[] prod = multiply(n1,n2);
        for(int i:prod)
            System.out.print(i);
    }
}
