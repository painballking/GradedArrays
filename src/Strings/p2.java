package Strings;

public class p2 {
    public static void main(String args[]) {
        String input = "        here    are   a     lot         of   spaces    .";

        StringBuffer ret = new StringBuffer();

        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) != ' '){
                ret.append(input.charAt(i));
            }
            else if(i > 0 && input.charAt(i-1) != ' '){
                    ret.append(" ");
                }
        }
        ret.deleteCharAt(ret.length()-2);
        System.out.println(ret);
    }
}
