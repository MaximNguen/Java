import java.util.*;

public class taskFive{
	public static void main(String[] args){
		int[] arr = new int[10];
		int minNum = 10000, maxNum = 0, indexMin = 0, indexMax = 0;

		System.out.println("Write down 10 elements for array");
		for (int i  = 0; i < 10; i++){
			Scanner in = new Scanner(System.in);
			arr[i] = in.nextInt();
			if (arr[i] > maxNum){
				maxNum = arr[i];
				indexMax = i;
			}
			if (arr[i] < minNum){
				minNum = arr[i];
				indexMin = i;
			}
			
		}

		for (int i = 0; i < 10; i++){
			System.out.printf("%d ", arr[i]);
		}
		
		System.out.println("\n ");
		boolean NuhUh = false;

		for (int i = 0; i < 10; i++){
			if (i > indexMin && i < indexMax && NuhUh == false){
				for (int j = Math.max(indexMax, indexMin)-1; j > Math.min(indexMin, indexMax); j--){
					System.out.printf("%d ", arr[j]);
					i++;
				}
				i--;
				NuhUh = true;
			} else {
				System.out.printf("%d ", arr[i]);
			}
		}
	}
}