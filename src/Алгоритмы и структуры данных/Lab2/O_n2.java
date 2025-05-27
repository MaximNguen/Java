public class O_n2 {
    public static int[] Insert(int[] array){
        for(int i = 0; i < array.length; i++){
            int element = array[i], j = i;
            while (j > 0 && element < array[j-1]){
                array[j] = array[j-1];
                j--;

            }
            array[j] = element;
        }
        return array;
    }
}
