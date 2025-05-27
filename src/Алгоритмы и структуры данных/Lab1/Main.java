import java.util.*;

class Main {
    public static void main(String[] args){
        LinkedList dll = new LinkedList();
        System.out.println("Двусвязанный список");
        dll.MoreImportant("Сделать домашнее задание");
        dll.LessImportant("Поиграть в игры");
        dll.MoreImportant("Изучить алгоритмы");
        dll.printList();
        dll.RemoveMoreImportant();
        dll.printList();
        dll.RemoveLessImportant();
        dll.printList();

        System.out.println();
        System.out.println("Очередь");
        Queue queue = new Queue();
        queue.In(5);
        queue.printList();
        queue.In(10);
        queue.printList();
        queue.In(15);
        queue.printList();
        queue.Out();
        queue.printList();
        queue.Out();
        queue.printList();

        System.out.println();
        System.out.println("Задание 2, введите количество элементов массива и введите массивы");

        int a;
        Scanner num = new Scanner(System.in);
        a = num.nextInt();
        int[] arr = new int[a];

        for (int i = 0; i < a; i++){
            arr[i] = (int)(Math.random() * 10000);
        }

        for (int i = 0; i < a; i++){
            System.out.printf("%d ", arr[i]);
        }

        long start = System.nanoTime();
        int[] arrNew = InsertSorting.Insert(arr);
        long end = System.nanoTime();

        System.out.println();
        for (int i = 0; i < a; i++){
            System.out.printf("%d ", arrNew[i]);
        }
        System.out.println();
        System.out.printf("Время сортировки - %f ms", (float)(end-start) / 1000000);


        System.out.println();
        System.out.println("Задание 3, введите количество элементов массива и введите массивы");

        int a1;
        a1 = num.nextInt();
        int[] arr1 = new int[a1];

        for (int i = 0; i < a; i++){
            arr1[i] = (int)(Math.random() * 10000);
        }


        System.out.printf(Arrays.toString(arr1));
        long start1 = System.nanoTime();
        FastSort.quickSort(arr1, 0, arr1.length-1);
        long end1 = System.nanoTime();

        System.out.println();
        System.out.printf(Arrays.toString(arr1));
        System.out.println();
        System.out.printf("Время сортировки - %f ms", (float)(end1-start1) / 1000000);
    }
}