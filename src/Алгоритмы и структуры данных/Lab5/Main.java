
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Runtime runtime = Runtime.getRuntime();

        System.out.print("Введите количество элементов: ");
        int n = scanner.nextInt();

        // ========== LINKED LIST ==========
        LinkedList linkedList1 = new LinkedList();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList1.add(i);
        }
        long end = System.nanoTime();
        printResult("LinkedList Add", start, end, runtime);
        long start1 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList1.remove(i);
        }
        long end1 = System.nanoTime();
        printResult("LinkedList Delete", start1, end1, runtime);
        long start2 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList1.contains(i);
        }
        long end2 = System.nanoTime();
        printResult("LinkedList Contain", start2, end2, runtime);

        

        // ========== STACK ==========
        Stack stack = new Stack(n);
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        end = System.nanoTime();
        printResult("Stack Push", start, end, runtime);
        start1 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.remove();
        }
        end1 = System.nanoTime();
        printResult("Stack Pop", start1, end1, runtime);
        start2 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            stack.search(i);
        }
        end2 = System.nanoTime();
        printResult("Stack Search", start2, end2, runtime);

        // ========== QUEUE ==========
        Queue queue = new Queue(n);
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
        end = System.nanoTime();
        printResult("Queue Add", start, end, runtime);
        start1 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.dequeue();
        }
        end1 = System.nanoTime();
        printResult("Queue Delete", start1, end1, runtime);
        start2 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            queue.search(i);
        }
        end2 = System.nanoTime();
        printResult("Queue Search", start2, end2, runtime);

        // ========== DYNAMIC ARRAY ==========
        DynamicArray dynamicArray = new DynamicArray();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            dynamicArray.add(i);
        }
        end = System.nanoTime();
        printResult("DynamicArray Add", start, end, runtime);
        start1 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            dynamicArray.remove(i);
        }
        end1 = System.nanoTime();
        printResult("DynamicArray Delete", start1, end1, runtime);
        start2 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            dynamicArray.contains(i);
        }
        end2 = System.nanoTime();
        printResult("DynamicArray Search", start2, end2, runtime);

        // ========== HASH TABLE ==========
        HashTable hashTable = new HashTable();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashTable.put(i, i * 10);
        }
        end = System.nanoTime();
        printResult("HashTable Add", start, end, runtime);
        start1 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashTable.remove(i);
        }
        end1 = System.nanoTime();
        printResult("HashTable Delete", start1, end1, runtime);
        start2 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            hashTable.containsValue(i);
        }
        end2 = System.nanoTime();
        printResult("HashTable Contain", start2, end2, runtime);
    }

    private static void printResult(String name, long start, long end, Runtime runtime) {
        runtime.gc(); // Запрос на сборку мусора перед замером памяти
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("%s - Время: %d мкс, Память: %.2f МБ\n",
                name, (end - start) / 1000, usedMemory / (1024.0 * 1024.0));
    }
}

