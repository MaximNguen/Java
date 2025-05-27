import java.util.*;

public class Main {
    public static void main(String[] args){
        System.out.println("Задание 3 O(n^2), введите количество элементов массива и введите массивы");

        int a;
        Scanner num = new Scanner(System.in);
        a = num.nextInt();
        int[] arr = new int[a];

        for (int i = 0; i < a; i++){
            arr[i] = (int)(Math.random() * 10000);
        }


        long start = System.nanoTime();
        int[] arrNew = O_n2.Insert(arr);
        long end = System.nanoTime();

    
        System.out.println();
        System.out.printf("Время сортировки - %f ms\n", (float)(end-start) / 1000000);

        System.out.println("Задание 3 O(n*log(n)), введите количество элементов массива и введите массивы");

        int a1;
        a1 = num.nextInt();
        int[] arr1 = new int[a1];

        for (int i = 0; i < a; i++){
            arr1[i] = (int)(Math.random() * 10000);
        }


        System.out.printf(Arrays.toString(arr1));
        long start1 = System.nanoTime();
        O_nlog.quickSort(arr1, 0, arr1.length-1);
        long end1 = System.nanoTime();

    
        System.out.println();
        System.out.printf("Время сортировки - %f ms\n", (float)(end1-start1) / 1000000);

        


        int[] elements = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        long start2 = System.nanoTime();
        List<List<Integer>> subsets = O_kn.findAllSubsets(elements);
        long end2 = System.nanoTime();
        System.out.printf("Время сортировки - %f ms\n", (float)(end2-start2) / 1000000);
    }
}
