
public class Queue {
    private int[] array;
    private int front, rear, size;

    public Queue(int capacity) {
        array = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(int value) {
        if (size == array.length) throw new RuntimeException("Queue full");
        array[rear] = value;
        rear = (rear + 1) % array.length;
        size++;
    }

    public int dequeue() {
        if (size == 0) throw new RuntimeException("Queue empty");
        int val = array[front];
        front = (front + 1) % array.length;
        size--;
        return val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int remove() {
        return dequeue();
    }
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % array.length;
            if (array[index] == value) {
                return i; 
            }
        }
        return -1; 
    }
}