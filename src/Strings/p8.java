package Strings;

public class p8 {
    public static void main(String args[]) {
        String in1 = "capillary";
        String in2 = "marsupial";

        if(in2.length() > in1.length()){
            String store = in1;
            in1 = in2;
            in2 = store;
        }

        StringBuffer fin2 = new StringBuffer();
        for(int i=0; i<in1.length(); i++){
            fin2.append(" ");
        }
        fin2.append(in2);
        for(int i=0; i<in1.length(); i++){
            fin2.append(" ");
        }

        int mostMatched = 0;
        for(int i=0; i<(fin2.length()-in1.length()); i++){
            int matched = 0;
            for(int j=0; j<in1.length(); j++){
                if(in1.charAt(j) == fin2.charAt(j+i)){
                    matched++;
                }
            }
            if(matched>mostMatched){
                mostMatched = matched;
            }
        }
        int num = mostMatched * 2;
        int denom = in1.length() + in2.length();
        int lesser = Math.min(num,denom);
        for(int i=lesser; i>=0; i--){
            if (num%i==0 && denom%i==0){
                System.out.println(num);
                System.out.println(denom);
                int times = lesser/i;
                num /= times*i;
                denom /= times*i;
                break;
            }
        }
        if(num == 0){
            System.out.println("0");
        }
        else{
            System.out.println(num+"/"+denom);
        }
    }
}
