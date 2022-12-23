import java.util.Iterator;

public class LinkedList<Item extends Comparable<Item>> implements Iterable<Item> {
    private Node first = null;
    private Node last = null;
    private int count = 0;
    private int mergeCount;
    private Node firstStart, firstEnd, secondStart, secondEnd, mergeFirst, mergeEnd, current, previousCurrent;


    private class Node {
        final Item item;    // cannot change item once it is set in constructor
        Node next;          // can change next, though
        public Node(Item i, Node n) {
            item = i;
            next = n;
        }
    }

    public LinkedList() { }

    public LinkedList(Item[] fromList) {
        for(Item item : fromList) insert(item);
    }

    public void insert(Item item) {
        if (isEmpty()) {
        first = new Node(item,first);
        last = first;
        }else{
        last.next = new Node(item, last);
        last = last.next;}
        count++;
    }

    public Item remove() {
        Item item = first.item;
        first = first.next;
        count--;
        return item;
    }

    public boolean isEmpty() { return count == 0; }


    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Item next() {
                Item item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    /***********************************************************************
     * Rearranges the linked list in ascending order, using the natural order
     * and mergesort.
     ***********************************************************************/

    public void sort() {
        int numMerges = 0;
        last.next = null;
        while (!singleSort()) {
            numMerges++;
        }
    }
    boolean singleSort(){
        current = first;
        firstStart = first;
        int type = 0;
        mergeCount = 0;

        while(current != null){
            if(type == 2){
                merge();
                type = 0;
                firstStart = current;
                secondStart = null;// this then allows us to start the loop over
                //empty out all variables
            } else if (current.next != null && current.item.compareTo(current.next.item) <= 0) {
                previousCurrent = current;
                current = current.next; // change your first to the next position
                // here is where we continue on until we reach otherwise
            } else { // this means that it's out of order
                if (type == 0) {
                    firstEnd = current;
                    secondStart = current.next;
                    previousCurrent = current;
                    current = current.next;
                    firstEnd.next = null;
                    type = 1;
                } else {
                    secondEnd = current;
                    previousCurrent = current;
                    current = current.next;
                    secondEnd.next = null;
                    type = 2;
                }
            }
        }
        if(secondStart == null){ // here we append the contents in the first list to the end of the merged list
            firstEnd = previousCurrent;
            if(mergeCount ==0){
                first = firstStart;
            }else{
                last.next = firstStart;
            }
            last = firstEnd;
        }else{ // second start has been started, and a merge needs to happen
            secondEnd = previousCurrent;
            //previousCurrent.next = null;
            merge();
        }
        if (mergeCount == 0 && current == null && secondStart == null){
            return true;
        } else{
            return false;
        }
    }
    void merge() {
        mergeFirst = null;
        mergeEnd = null;

        //merge is called when a firstEnd and secondEnd are found
        while (firstStart != null || secondStart != null) {
            if (firstStart == null) {
                if (mergeFirst == null){ // if the new list is empty
                    mergeFirst = secondStart;
                    mergeEnd = secondEnd;
                    mergeEnd.next = null;
                    secondEnd = null;
                }else{
                    mergeEnd.next = secondStart;
                    mergeEnd = secondEnd;
                    mergeEnd.next = null;
                    secondStart = null;
                }
                // attach on the rest of the second array to the sorted section
            } else if (secondStart == null) {
                if (mergeFirst == null){ // if the new list is empty
                    mergeFirst = firstStart;
                    mergeEnd = firstEnd;
                    mergeEnd.next = null;
                    firstStart = null;
                }else{
                    mergeEnd.next = firstStart;
                    mergeEnd = firstEnd;
                    mergeEnd.next = null;
                    firstStart = null;
                }
                //place the rest of first array to the sorted section
            } else if (firstStart.item.compareTo(secondStart.item) <= 0) { // if firstStart should go first
                if (mergeFirst == null){ // if the new list is empty
                    mergeFirst = firstStart;
                    firstStart = firstStart.next;
                    mergeEnd = mergeFirst;
                    mergeEnd.next = null;
                } else {
                    mergeEnd.next = firstStart;
                    firstStart = firstStart.next;
                    mergeEnd = mergeEnd.next;
                    mergeEnd.next = null;
                }
            } else { // place secondStart
                if (mergeFirst == null){ // if the new list is empty
                    mergeFirst = secondStart;
                    secondStart = secondStart.next;
                    mergeEnd = mergeFirst;
                    mergeEnd.next = null;
                }
                else {
                    mergeEnd.next = secondStart;
                    secondStart = secondStart.next;
                    mergeEnd = mergeEnd.next;
                    mergeEnd.next = null;
                }
            }
        }
        if(mergeCount == 0){
            first = mergeFirst;
        }else{
            last.next = mergeFirst;
        }
        last = mergeEnd;
        mergeEnd.next = current;
        mergeCount++;
    }

    /***********************************************************************
     *  main() function
     *  Place all of your unit tests here
     *  Hint: created additional functions to help organize your tests
     ***********************************************************************/

    public static void main(String[] args) {
        Double[] a = {12.0, 4.9, 5.0, 14.0, 58.9, 32.8, 32.8, 14.5};
        // 12.0, 11.0, 10.0, 6.0, 4.0, 2.0, 1.0
        // 12.0, 4.9, 5.0, 14.0, 58.9, 32.8, 32.8, 14.5
        LinkedList<Double> linkedlist = new LinkedList<>(a);
        linkedlist.sort();
    }
}

