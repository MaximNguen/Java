
public class Stack {
    private int[] array;
    private int top;

    public Stack(int capacity) {
        array = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == array.length - 1) throw new RuntimeException("Stack overflow");
        array[++top] = value;
    }

    public int pop() {
        if (top == -1) throw new RuntimeException("Stack underflow");
        return array[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int remove() {
        return pop();
    }
    public int search(int value) {
        for (int i = top; i >= 0; i--) {
            if (array[i] == value) {
                return i; 
            }
        }
        return -1; 
    }
}