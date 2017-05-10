import java.util.*;

public class InfixToPostfix {

    static class Op{
        List<String> children = new ArrayList<String>();
        String op;
        boolean full;
        public Op(String n){
            op = n;
        }
        public boolean isFull(){ return children.size() == 2; }
        public String collapse(){ return "(" + children.get(0) + op + children.get(1) + ")"; }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Stack<Op> operators = new Stack();
        Stack<String> operands = new Stack();

//        String input = "+ * 3 + + 4 5 6 7";
//        String[] in = input.split(" ");
        String[] in = s.nextLine().split("");

        for(int i=0; i<in.length; i++){
            if(in[i].equals("+") || in[i].equals("*")){
                operators.add(new Op(in[i]));
            } else {
               operands.add(in[i]);
                if( operators.peek().children.size() == 0 ) {
                    operators.peek().children.add(in[i]);
                } else if( operators.peek().children.size() == 1){
                    operators.peek().children.add(in[i]);
                    operands.pop(); operands.pop();
                    operands.add(operators.pop().collapse());
                    while(operators.size() > 0 && operators.peek().children.size() < 2 ){
                        operators.peek().children.add(operands.peek());

                        if( operators.peek().children.size() == 2){
                            operands.pop(); operands.pop();
                            operands.add(operators.pop().collapse());
                            continue;
                        }
                        if( operators.peek().children.size() == 1){
                            break;
                        }
                    }
                }
            }
//            if(!operands.isEmpty()) System.out.println(operands.peek());
        }

        System.out.println(operands.peek());

    }
}
