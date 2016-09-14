public class p4 {
    public static void main(String args[]) {
        int[] num1 = {4, 9, 0, 2, 8, 1, 7, 2, 6, 3, 7, 4, 8, 5, 0, 2, 8, 8, 3, 1};
        int[] num2 = {8, 4, 9, 2, 7, 1, 6, 5, 8, 0, 9, 8, 7, 2, 6, 3, 1, 5, 2, 4};
        //Sub ans = 35 898 993 172 387 602 693

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


    }
}
