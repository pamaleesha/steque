public class Steque<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
    }

    public Steque() {
        first = null;
        last = null;
        size = 0;
    }

    // Push: Add an item to the front
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (size == 0) {
            last = first;
        }
        size++;
    }

    // Enqueue: Add an item to the end
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (size == 0) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    // Pop: Remove and return the item from the front
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Steque is empty");
        }
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    // Check if the steque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the number of items in the steque
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.push(1);
        steque.push(2);
        steque.push(3);
        System.out.println("Pop: " + steque.pop()); // Should print 3
        steque.enqueue(4);
        steque.enqueue(5);
        System.out.println("Pop: " + steque.pop()); // Should print 2
        System.out.println("Pop: " + steque.pop()); // Should print 1
        System.out.println("Pop: " + steque.pop()); // Should print 4
        System.out.println("Pop: " + steque.pop()); // Should print 5
    }
}
