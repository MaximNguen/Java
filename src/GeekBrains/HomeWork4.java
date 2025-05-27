import java.util.Scanner;
import java.util.Random;

public class HomeWork4 {
    private static final char X_POINT = 'X';
    private static final char O_POINT = 'O';
    private static final char EMPTY_POINT = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int figures;

    public static void main(String[] agrs){
        initField();
        printField();
        while (!checkWin(field)) {
            humanTurn();
            aiTurn();
            printField();
        }
    }

    private static void initField(){
        fieldSizeX = SCANNER.nextInt();
        fieldSizeY = SCANNER.nextInt();
        field = new char[fieldSizeY][fieldSizeX];
        figures = field.length;
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++){
                field[y][x]= EMPTY_POINT;
            }
        }
    }

    private static void printField(){
        System.out.print(" ");
        for (int x = 0; x < fieldSizeX; x++){
            System.out.print(" " + (x + 1));
        }
        System.out.println();
        for (int y = 0; y < fieldSizeY; y++){
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        int valueX, valueY;
        do {
            System.out.println("Put coordinates to place X or O");
            valueX = SCANNER.nextInt();
            valueY = SCANNER.nextInt();

        } while (!placeIsEmpty(valueY, valueX) || !boundIsNorm(valueY, valueX));

        field[valueY][valueX] = X_POINT;
    }

    private static void aiTurn(){
        int aiValueX, aiValueY;
        do {
            aiValueX = RANDOM.nextInt(fieldSizeX);
            aiValueY = RANDOM.nextInt(fieldSizeY);
        } while (!placeIsEmpty(aiValueY, aiValueX) || !boundIsNorm(aiValueY, aiValueX));
    }

    private static boolean checkWin(char[][] fieldToCheck) {
        int checkCounterHuman = 0;
        int checkCounterAI = 0;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (fieldToCheck[y][x] == O_POINT) {
                    checkCounterHuman++;
                } else if (fieldToCheck[y][x] == X_POINT) {
                    checkCounterAI++;
                }
            }
            if (checkCounterHuman == figures) {
                System.out.println("You win");
                return true;
            } else if (checkCounterAI == figures) {
                System.out.println("You lose");
                return true;
            }

            checkCounterAI = 0;
            checkCounterHuman = 0;
        }
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (fieldToCheck[y][x] == X_POINT){
                    checkCounterHuman++;
                } else if (fieldToCheck[y][x] == O_POINT){
                    checkCounterAI++;
                }
            }
            if (checkCounterHuman == figures){
                System.out.println("You win");
                return true;
            } else if (checkCounterAI == figures){
                System.out.println("You lose!");
                return true;
            }
            checkCounterAI=0;
            checkCounterHuman=0;

        }
        return false;
    }


    private static boolean boundIsNorm(int valueY, int valueX){
        return valueX >= 0 && valueY >= 0 && valueX < fieldSizeX && valueY < fieldSizeY;
    }

    private static boolean placeIsEmpty(int valueY, int valueX){
        return field[valueY][valueX] == EMPTY_POINT;
    }
}
