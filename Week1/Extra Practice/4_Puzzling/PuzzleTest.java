import java.util.Random;

public class PuzzleTest {
    public static void main(String[] args) {
        PuzzleJava appTest = new PuzzleJava();
        System.out.println(appTest.getTenRolls());
        System.out.println(appTest.getRandomLetter());
        System.out.println(appTest.generatePassword());
        System.out.println(appTest.getNewPasswordSet(5));

    }
}
