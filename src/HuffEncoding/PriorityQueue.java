package HuffEncoding;

import java.util.ArrayList;

public class PriorityQueue {
    private ArrayList<HuffmanTree> queue;

    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    /** 
     * Pushes a node onto the priority queue based on the node's frequency.
     */
    public void push(HuffmanTree toAdd) {
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getFreq() > toAdd.getFreq()) {
                queue.add(i, toAdd);
                return;
            }
        }
        queue.add(toAdd);
    }

    /** 
     * Pops the node/tree of lowest frequency from the queue.
     */
    public HuffmanTree pop() {
        return queue.remove(0);
    }

    /** 
     * Returns the number of elements in the queue.
     */
    public int length() {
        return queue.size();
    }
}
