package HuffEncoding;

import java.util.HashSet;
import java.util.Set;

public class HuffTools {
    /**
     * Converts a string to a set of its characters.
     */
    public static Set<Character> toSet(String str) {
        Set<Character> charsInStr = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            charsInStr.add(str.charAt(i));
        }
        return charsInStr;
    }

    /**
     * Returns how many times 'character' appears in 'str'.
     */
    public static int freqOfCharacter(char character, String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == character) {
                count ++;
            }
        }
        return count;
    }

    /**
     * Creates the priority queue used to construct the Huffman tree.
     * Each element is a node which has a symbol and a frequency attribute.
     */
    public static PriorityQueue createHuffPriQ(String str) {
        PriorityQueue priQ = new PriorityQueue();

        Set<Character> charsInStr = toSet(str);
        for (char character : charsInStr) {
            int characterFreq = freqOfCharacter(character, str);
            HuffmanTree node = new HuffmanTree(character, characterFreq);
            priQ.push(node);
        }
        return priQ;
    }

    /** 
     * Creates a new node which is the parent of the two trees input.
     * This new node has no symbol and its frequency is the sum of the two child nodes' frequencies.
     */
    public static HuffmanTree combine(HuffmanTree node1, HuffmanTree node2) {
        int newFreq = node1.getFreq() + node2.getFreq();
        HuffmanTree newTree = new HuffmanTree(newFreq, node1, node2);
        return newTree;
    }

}
