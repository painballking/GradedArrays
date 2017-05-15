package Huffman;

public class Runner {
    public static void main(String[] args) {
        Huffman h = new Huffman();

        String message = "The junker errs into a bottle! A speaking picture acts. Its port stress volunteers behind the all life. A bonus dresses across whatever seed! A rhetorical muddle fears.";
        String code = h.encode(message);

        System.out.println(message.length() * 8 + " bits");
        System.out.printf("%d (%d bytes + %d bits)\n", code.length(), code.length() / 8, code.length() % 8);

        h.calculateDecoderBits();
    }
}
