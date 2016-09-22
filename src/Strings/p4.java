package Strings;

public class p4 {
    public static void main(String args[]) {
        String input1 = "ryan";
        String input2 = "chase";

        boolean none = false;
        if(input1.length() > input2.length()){
            for(int i=0; i<input2.length(); i++){
                if(input1.indexOf(input2.charAt(i)) == -1){
                    System.out.println("Neither dominates the other");
                    none = true;
                    break;
                }
            }
            if(!none)
                System.out.println("s1 dominates s2");
        }
        else{
            for(int i=0; i<input1.length(); i++){
                if(input2.indexOf(input1.charAt(i)) == -1){
                    System.out.println("Neither dominates the other");
                    none = true;
                    break;
                }
            }
            if(!none)
                System.out.println("s2 dominates s1");
        }
    }
}
