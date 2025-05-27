import java.util.Arrays;

public class HomeWork2 {
    static int[] arr = {0,1,1,0,1};

    public static int[] switcherZeroAndOne(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 1){
                arr[i] = 0;
            }
            else{
                arr[i] = 1;
            }
        }

        return arr;
    }

    


    public static void main(String[] args){
        System.out.println(Arrays.toString(switcherZeroAndOne(arr)));
    }

}
