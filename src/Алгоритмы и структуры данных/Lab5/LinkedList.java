
public class LinkedList {
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;

    public void add(int value) {
        if (head == null) head = new Node(value);
        else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = new Node(value);
        }
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) return true;
            current = current.next;
        }
        return false;
    }

    public boolean remove(int value) {
        if (head == null) return false;

        if (head.value == value) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }
}