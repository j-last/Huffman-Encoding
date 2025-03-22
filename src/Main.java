import HuffEncoding.HuffmanEncoding;

public class Main {
    public static void main(String[] args) {

        // TESTING original string -> encode -> decode == original string

        String stringToEncode = "I would walk 500 miles, and I would walk 500 more!";
        HuffmanEncoding huffTree = new HuffmanEncoding(stringToEncode);

        String encodedString = huffTree.encode(stringToEncode);
        System.out.println(encodedString);

        String decodedString = huffTree.decode(encodedString);
        System.out.println(decodedString);
    }
}