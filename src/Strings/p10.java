package Strings;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class p10 {

    static String swapped(String input, String[] dict){
        for(int i=0; i<input.length()-1; i++){
            String test = (input.substring(0,i)+
                    input.substring(i+1,i+2)+
                    input.substring(i,i+1)+
                    input.substring(i+2));
            if(asList(dict).contains(test)){
                return asList(dict).get(asList(dict).indexOf(test));
            }
        }
        return "";
    }

    static String doubleLetter(String input, String[] dict){
        for(int i=1; i<input.length(); i++){
            if(input.charAt(i) == input.charAt(i-1)){
                String test = input.substring(0,i-1)+input.substring(i);

                if(asList(dict).contains(test)){
                    return asList(dict).get(asList(dict).indexOf(test));
                }
            }
        }
        return "";
    }

    static String nearbyKey(String input, String[] dict){
        Map<Character, String> nearKeys = new HashMap<>();
        nearKeys.put('q',"asw");
        nearKeys.put('w',"qasde");
        nearKeys.put('e',"wsdfr");
        nearKeys.put('r',"edfgt");
        nearKeys.put('t',"rfghy");
        nearKeys.put('y',"tghju");
        nearKeys.put('u',"yhjki");
        nearKeys.put('i',"ujklo");
        nearKeys.put('o',"iklp");
        nearKeys.put('p',"ol");
        nearKeys.put('a',"qwsxz");
        nearKeys.put('s',"aqwedcxz");
        nearKeys.put('d',"werfvcxs");
        nearKeys.put('f',"ertgbvcd");
        nearKeys.put('g',"rtyhnbvf");
        nearKeys.put('h',"tyujmnbg");
        nearKeys.put('j',"yuikmnh");
        nearKeys.put('k',"uiolmj");
        nearKeys.put('l',"iopk");
        nearKeys.put('z',"asx");
        nearKeys.put('x',"zsdc");
        nearKeys.put('c',"xdfv");
        nearKeys.put('v',"cfgb");
        nearKeys.put('b',"vghn");
        nearKeys.put('n',"bhjm");
        nearKeys.put('m',"njk");

        for(int i=0; i<input.length(); i++){
            for(int j=0; j<nearKeys.get(input.charAt(i)).length(); j++){
                String test =   input.substring(0,i)+
                                nearKeys.get(input.charAt(i)).charAt(j)+
                                input.substring(i+1);

                if(asList(dict).contains(test)){
                    return asList(dict).get(asList(dict).indexOf(test));
                }
            }
        }
        return "";
    }

    public static void main(String args[]) {
        String[] wordlist = {"apple", "birthday", "default", "handy", "mississippi", "orange"};

        String input = "biryhday";

        if(asList(wordlist).contains(input)){
            System.out.println("You have spelled the word correctly!");
        }
        else{
            String swap = swapped(input, wordlist);
            if(swap != ""){
                System.out.println("Did you mean "+swap);
                System.exit(0);
            }

            String dubble = doubleLetter(input, wordlist);
            if(dubble != ""){
                System.out.println("Did you mean "+dubble);
                System.exit(0);
            }

            String nearKey = nearbyKey(input, wordlist);
            if(nearKey != ""){
                System.out.println("Did you mean "+nearKey);
                System.exit(0);
            }

            System.out.println("Could not find your word!");
        }
    }
}
