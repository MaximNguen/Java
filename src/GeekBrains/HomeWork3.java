import java.util.*;

public class HomeWork3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[][] arr = new int[a][a];

        for (int i = 0; i < a; i++){
            for (int j  = 0; j < a; j++){
                if (i == j){
                    arr[i][j] = 1;
                }
            }
        }
        
        Arrays.stream(arr).forEach(row -> System.out.println(Arrays.toString(row)));
        
        findNumber();
        findWord();
    }

    static void findNumber(){
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int numToFind = rnd.nextInt(9), inputNum, i = 3;
        while ( i != 0){
            System.out.println("Attempts left - " + i);
            inputNum = in.nextInt();
            if (inputNum > numToFind){
                System.out.println("NumToFind is smaller");
                i--;
            } else if (inputNum < numToFind){
                System.out.println("NumToFind is bigger");
                i--;
            } else{
                System.out.println("You guessed right number! GameOver betches");
                break;

            }

            if (i == 0){
                System.out.println("wanna continue? 1 - yes, 0 - Nah this game sucks man");
                int choice = in.nextInt();
                if (choice == 1){
                    i = 3;
                } else{
                    break;
                }
            }
        }
    }

    static void findWord(){
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        String[] words = {"apple", "nut", "olive", "avocado","melon", "leak", "kiwi", "mango", "mushroom"};
        System.out.println("all words able to guess " + Arrays.toString(words));
        int indexOfWordToFind = random.nextInt(words.length);

        String wordToFind = words[indexOfWordToFind], inputWord, symbols = "";

        while (true){
            inputWord = in.next();
            if (inputWord.equals(wordToFind)){
                System.out.println("You won");
                break;
            } else{
                System.out.println("Try again - " + Arrays.toString(words));
                if (inputWord.length() >= wordToFind.length()){
                    System.out.println(elseToFindFunction(wordToFind, inputWord, symbols));
                } else{
                    System.out.println("Need more letters");
                }

            }
        }
    }
    

    static String elseToFindFunction(String wordToFind, String inputWord, String symbols){
        for (int i = 0; i < 15; i++){
            if (i < wordToFind.length()){
                if (inputWord.charAt(i) == wordToFind.charAt(i)){
                    symbols += wordToFind.charAt(i);
                } else{
                    symbols += "#";
                }

            } else{
                symbols += "#";
            }
        }
        return symbols;

    }
}
