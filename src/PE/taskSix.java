import java.util.*;

public class taskSix {
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

        int n = arr.length, cntPromezhutki = 0, checkNums = 1;
        ArrayList<Integer> indexs = new ArrayList<>();

        if (n < 3) // Будем считать, что промежуток состоит минимум из 3 чисел (2 - пара)
        {
            System.out.println("0 Промежутков");
        } else {
            for (int i = 0; i < n-1; i++){
                if (arr[i] < arr[i+1]) {
                    checkNums+=1;
                } else{
                    if (checkNums >= 3) {
                        indexs.add(i-checkNums+1);
                        indexs.add(i);
                        cntPromezhutki +=1;
                        checkNums = 1;
                        
                    }
                }
            }
            if (checkNums >= 3) {
                indexs.add(n-checkNums+1);
                indexs.add(n);
                cntPromezhutki +=1;
                checkNums = 1;
                
            }
            checkNums = 1;
            for (int i = 0; i < n-1; i++){
                if (arr[i] > arr[i+1]) {
                    checkNums+=1;
                } else {
                    if (checkNums >= 3) {
                        indexs.add(i-checkNums+1);
                        indexs.add(i);
                        cntPromezhutki +=1;
                        checkNums = 1;
                        
                    }
                }
            }
            if (checkNums >= 3) {
                indexs.add(n-checkNums+1);
                indexs.add(n);
                cntPromezhutki +=1;
                checkNums = 1;
                
            }
            
        }
        System.out.println("\n");
        System.out.printf(indexs + " ");
        System.out.printf("Это индексы точек промежуток");
        System.out.println("\n");
        System.out.printf("%d Промежутков", cntPromezhutki);

        ArrayList<Integer> newArr = new ArrayList<>();

        for (int i = indexs.get(indexs.size()-2); i < indexs.get(indexs.size()-1) + 1; i++) {
            newArr.add(arr[i]);
        }

        for (int i = indexs.get(1) + 1; i < indexs.get(indexs.size()-2); i++) {
            newArr.add(arr[i]);
        }

        for (int i = indexs.get(0); i < indexs.get(1) +1; i++) {
            newArr.add(arr[i]);
        }

        if (indexs.size() != n){
            for (int i = indexs.get(indexs.size()-1) + 1; i < n; i++) {
                newArr.add(arr[i]);
            }
        }

        System.out.println("\n");
        System.out.printf(newArr + " ");

    }
}
