package com.bgu.workground.assignment2.MemoryManagement;

/**
 *
 */
public class SuperQueue implements MyQueue<Node<Page>> {

    private int maxSize;
    private int currentSize;
    private Pointer<Page>[]pointers;

    private Node<Page> first;
    private Node<Page> last;

    public Pointer<Page>[] getPointers() {
        return pointers;
    }

    public Node<Page> getFirst() {
        return first;
    }

    public Node<Page> getLast() {
        return last;
    }

    public SuperQueue(int maxSize, String[] secondaryMemory, boolean isLRU){
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.first = new Node<Page>(null, null, null);
        this.last = first;
        this.pointers = new Pointer[secondaryMemory.length];
        initQueue(secondaryMemory);
    }

    public void initQueue(String[] secondaryMemory) {
        for (int i = 0; i < maxSize; i++) {
            append(i,secondaryMemory[i]);
        }
    }

    //Add a node at the end of the list
    void append(int index, String data)
    {
        //put in  a new node
        Page p = new Page(index,data);
        Node<Page> myNode = new Node<Page>(last, null, p);
        append(myNode);
    }

    public void lruUpdate(Node<Page> tempNode){
        // If this is the first node, leave the list as it is
        if (tempNode.element.key == last.element.key){
            return;
        }

        // Get the next and previous nodes
        Node nextNode = tempNode.next;
        Node previousNode = tempNode.previous;

        // If at the left-most, we update first item
        if (tempNode.element.key == first.element.key){
            nextNode.previous = null;
            first = nextNode;
        }

        // If we are in the middle, we need to update the items before and after our item
        else if (tempNode.element.key != last.element.key){
            previousNode.next = nextNode;
            nextNode.previous = previousNode;
        }

        // Finally move our item to the last
        tempNode.previous = last;
        last.next = tempNode;
        last = tempNode;
        last.next = null;
    }

    @Override
    public boolean isFull() {
        return currentSize == maxSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }


    @Override
    public Node<Page> removeFirst() {
        // Delete the first item and update the list
        Node<Page> remove = first;
        pointers[first.element.key] = null;
        first = first.next;
        if (first != null)
            first.previous = null;
        currentSize--;
        return remove;
    }

    public void append(Node<Page> myNode) {
        // Put the new node at the end of the linked-list
        last.next = myNode;
        pointers[myNode.element.key] = new Pointer<Page>(myNode);
        last = myNode;

        // Update current size counter, for the first added entry
        if (currentSize < maxSize){
            if (currentSize == 0){
                first = myNode;
            }
            currentSize++;
        }
    }





}
