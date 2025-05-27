import java.util.*;

public class Main {
    public Main() {

    }

    public static void main(String[] args) {
        System.out.println("Task 1");
        System.out.println(calculateExpression(3f, 5f, 12f, -4f));
    }

    static float calculateExpression(float a, float b, float c, float d){
        return a * (b + (c / d));
    }

}