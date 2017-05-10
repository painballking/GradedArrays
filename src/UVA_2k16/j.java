package UVA_2k16;
import java.nio.IntBuffer;
import java.util.*;

public class j {

    static class Interpreter{
        String op_string;
        StringBuilder ret;
        byte[] var = new byte[256];

        public Interpreter(String s){
            op_string = s;
            ret = new StringBuilder();
        }

        public void evaluate(){
            String op;
            int pc = var[0];
            op = op_string.substring(pc, pc+2);

            switch (op){
                case "00":
                    byte x = Byte.parseByte(op_string.substring(pc+2, pc+3), 16);
                    byte y = Byte.parseByte(op_string.substring(pc+3, pc+4), 16);
                    var[x] = y;
                case "01":
                    break;
            }
        }

    }

    public static void main(String args[]) {
        String op = "001100";
        Interpreter i = new Interpreter(op);
        i.evaluate();
    }
}
