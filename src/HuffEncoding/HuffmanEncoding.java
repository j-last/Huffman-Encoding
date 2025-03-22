package HuffEncoding;

import java.util.Map;
import java.util.HashMap;

public class HuffmanEncoding {
    HuffmanTree tree;
    Map<Character, String> codes;
    
    /** 
     * Creates the Huffman tree and code mapping dictionary for the Huffman tree.
     */
    public HuffmanEncoding(String str) {
        // Create the actual Huffman tree.
        PriorityQueue priQ = HuffTools.createHuffPriQ(str);
        tree = constructTree(priQ);

        // Creates a dictionary that maps characters -> binary codes.
        codes = new HashMap<>();
        leavesToCodes(tree, "");
    }

    /** 
     * Continually combines nodes in the priority queue until only the root of the Huffman tree remains.
     */
    public HuffmanTree constructTree(PriorityQueue priQ) {
        int timesToCombine = priQ.length() - 1;
        for (int i = 0; i < timesToCombine; i++) {
            // Ccombine the two nodes of the lowest frequency and push this back to the queue.
            priQ.push(HuffTools.combine(priQ.pop(), priQ.pop()));
        }
        return priQ.pop();
    }

    /** 
     * Traverses the tree using a depth-first search.
     * When a leaf node is reached, its symbol and Huffman binary code are added to 'codes'.
     */
    public void leavesToCodes(HuffmanTree huffTree, String code) {
        if (huffTree.isLeafNode()) {
            codes.put(huffTree.getSymbol(), code);
        } else {
            // Left transitions correspond to a 0, right transitions correspond to a 1.
            leavesToCodes(huffTree.getLeftChild(), code + "0");
            leavesToCodes(huffTree.getRightChild(), code + "1");
        }
    }

    /**
     * Encodes a string of characters using the Huffman tree created.
     */
    public String encode(String toEncode) {
        String encodedString = "";
        // Uses the 'codes' mapping to get binary codes from the characters of the string.
        for (int i = 0; i < toEncode.length(); i++) {
            encodedString += codes.get(toEncode.charAt(i));
        }
        return encodedString;
    }

    /** 
     * Decodes a binary string using the Huffman tree created.
     */
    public String decode(String toDecode) throws IllegalArgumentException {
        String decodedString = "";
        HuffmanTree currentNode = tree;
        for (int i = 0; i < toDecode.length(); i++) {
            // If a leaf node is reached, that is the symbol that has been encoded.
            if (currentNode.isLeafNode()) {
                decodedString += currentNode.getSymbol();
                currentNode = tree;
            }
            // Otherwise continue traversing the tree: 0=left, 1=right
            switch (toDecode.charAt(i)) {
                case '0':
                    currentNode = currentNode.getLeftChild();
                    break;
                case '1':
                    currentNode = currentNode.getRightChild();
                    break;
            }
        }
        if (currentNode.isLeafNode()) {
            // The final binary code is converted to a symbol.
            decodedString += currentNode.getSymbol();
        } else {
            throw new IllegalArgumentException("The encoded string provided is not valid for this Huffman tree.");
        }
        return decodedString;
    }
}
