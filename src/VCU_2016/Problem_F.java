package VCU_2016;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Problem_F {

    public static boolean isOp(String op){
        return op.equals("+") || op.equals("*");
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        Stack<String> ops = new Stack();
        Stack<Stack<String>> topDaddy = new Stack();
        String[] input = scan.nextLine().split(" ");
        String next = "";
        for(String s : input){
            if(isOp(s)){
                ops.push(s);
                topDaddy.push(new Stack());
            }
            else{
                topDaddy.peek().push(s);
                while(topDaddy.size() > 1 && topDaddy.peek().size() == 2){
                    String store = topDaddy.peek().pop();
                    next = "(" + topDaddy.peek().pop() + ops.peek() + store + ")";
//                    if(topDaddy.size() > 1) {
                    ops.pop();
                    topDaddy.pop();
                    topDaddy.peek().push(next);
//                    }
                }
            }
        }
        String first = topDaddy.peek().pop();
        System.out.println("("+topDaddy.peek().pop()+ops.peek()+first+")");
    }
}
