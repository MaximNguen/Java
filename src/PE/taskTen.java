import java.util.*;

public class taskTen{
	public static void main(String[] args){
		System.out.println("Write down count of element in array");
		Scanner in1 = new Scanner(System.in);
		int a = in1.nextInt();
		int[] arr = new int[a];
		
		System.out.println("Write down " + a + " elements");
		for (int i = 0; i < a; i++){
			// Scanner numNew = new Scanner(System.in);
			arr[i] = in1.nextInt();;
		}
		for (int i = 0; i < a; i++){
			System.out.printf("%d ", arr[i]);
		}
		
		int ptSimple = 0;
		int ptNice = 0;
		boolean simple = false;
		boolean nice = false;
		
		for (int i = 0; i < a; i++){
			int cnt = 0;
			int sum = 0;
			for (int j = 1; j < arr[i]+1; j++){
				if (arr[i] % j == 0){
					cnt++;
					sum+=j;
				}
			}
			if (cnt == 2 && simple == false){
				ptSimple = i;
				simple = true;
			}
			if (sum-arr[i] == arr[i] && nice == false){
				ptNice = i;
				nice = true;
				
			}
			if (simple && nice){
				break;
			}
			
			
		}
		
		int temp = arr[ptNice];
		arr[ptNice] = arr[ptSimple];
		arr[ptSimple] = temp;
		
		System.out.println();
		for (int i = 0; i < a; i++){
			System.out.printf("%d ", arr[i]);
		}
		
	}
}