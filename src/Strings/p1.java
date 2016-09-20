package Strings;

public class p1 {
    public static void main(String args[]) {
        String input = "computer";

        StringBuffer ret = new StringBuffer();
        boolean unique = true;
        for(int i=0; i<input.length(); i++){
            if(!input.substring(0,i).contains(input.substring(i,i+1))){
                ret.append(input.substring(i,i+1));
            }
            else
                unique = false;
        }
        if(unique){
            String vowels = "aeiou";
            for(int i=0; i<ret.length(); i++){
                if(!vowels.contains(ret.substring(i,i+1))){
                    ret.delete(i,i+1);
                    i--;
                }
            }
        }
        System.out.println(ret);
    }
}
