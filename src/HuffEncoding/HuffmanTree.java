package HuffEncoding;


public class HuffmanTree {
    private char symbol;
    private int freq;
    private HuffmanTree left;
    private HuffmanTree right;

    /** 
     * Leaf node constructor (left & right children are null).
     */
    public HuffmanTree(char symbol, int freq) {
        this.symbol = symbol;
        this.freq = freq;
    }

    /** 
     * Parent node constructor.
     * Only leaf nodes need symbols associated with them in a Huffman tree.
    */
    public HuffmanTree(int freq, HuffmanTree leftChild, HuffmanTree rightChild) {
        left = leftChild;
        right = rightChild;
        this.freq = freq;
    }

    public boolean isLeafNode() {
        return (left == null);
    }

    public char getSymbol() {
        return symbol;
    }

    public int getFreq() {
        return freq;
    }

    public HuffmanTree getLeftChild() {
        return left;
    }

    public HuffmanTree getRightChild() {
        return right;
    }
}
