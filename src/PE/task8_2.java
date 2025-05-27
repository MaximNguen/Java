import java.util.Scanner;

public class task8_2 {
    public static void main(String[] args) {
        System.out.println("Введите количество массивов");
		Scanner in = new Scanner(System.in);
		int q = in.nextInt(), minNum = 10000;
        int q1 = q;
		
		int[] arr = new int[q];
        for (int i = 0; i < q; i++){
			arr[i] = (int)(Math.random() * 50 - 25);
			System.out.printf("%d ", arr[i]);
			if (arr[i] < minNum){
				minNum = arr[i];
			}
            if (arr[i] > 0 && arr[i] % 2 == 0){
                q1++;
            }
		}

        int[] newArr = new int[q1];
        int i1 = 0;
        System.out.println();

        for (int i = 0; i < q; i++){
			newArr[i1] = arr[i];
            i1++;
            if (arr[i] > 0 && arr[i] % 2 == 0) {
                newArr[i1] = minNum;
                i1++;
            }
		}

        for (int i = 0; i < q1; i++){
            System.out.printf("%d ", newArr[i]);
        }




    }
}
