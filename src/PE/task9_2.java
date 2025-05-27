import java.util.*;

public class task9_2{
	public static void main(String[] args){
		System.out.println("Введите количество массивов");
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		
		int[] arr = new int[q];
		int negativeNonChetCnt = 0, positiveChetCnt = 0; 

		for (int i = 0; i < q; i++){
			arr[i] = (int)(Math.random() * 50 - 25);
			System.out.printf("%d ", arr[i]);
			if (arr[i] < 0 && arr[i] % 2 == 0){
				negativeNonChetCnt++;
			}
			if (arr[i] > 0 && arr[i] % 2 == 1){
				positiveChetCnt++;
			}
		}
		System.out.println();

		int q1 = positiveChetCnt+negativeNonChetCnt+q, i1 = 0;
		int[] newArr = new int[q1];

		for (int i = 0; i < q; i++) {
			newArr[i1] = arr[i];
			i1++;
			if (arr[i] < 0 && arr[i] % 2 == 0){
				newArr[i1] = 1;
				i1++;
			} 
			if (arr[i] > 0 && arr[i] % 2 == 1){
				newArr[i1] = 0;
				i1++;
			}
		}

		for (int i = 0; i < q1; i++ ){
			System.out.printf("%d ", newArr[i]);

		}



		
	}
}