import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    Random rand = new Random();
// To use methods from the Random library you will need to create an instance of Random
// getTenRolls
// Write a method that will generate and return an array with 10 random numbers between 1 and 20 inclusive.

//
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randArray = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            randArray.add(rand.nextInt(20));
        }
        return randArray;
    }

    // getRandomLetter

    // Write a method that will:
    // Create an array within the method that contains all 26 letters of the alphabet (this array must have 26 values). 
    // Generate a random index between 0-25, and use it to pull a random letter out of the array.
    // Return the random letter
    
    
    public String getRandomLetter() {
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = String.valueOf(alphabetString.charAt(i));
        }
        String randomLetter = alphabet[rand.nextInt(26)];
        return randomLetter;
    }

    // generatePassword 
    // Write a method that uses the previous method to create a random string of eight characters,and return that string.
    public String generatePassword() {
        String password = "";
        for (int i = 1; i <= 8; i++) {
            password += getRandomLetter();
        }
        return password;
    }

    // getNewPasswordSet
    // Write a method that takes an int length as an argument and creates an array of random eight character words.
    // The array should be the length passed in as an int.
    public ArrayList<String> getNewPasswordSet(int length) {
        ArrayList<String> randArrayPassword = new ArrayList<String>();

        for (int i = 1; i <= length; i++) {
            randArrayPassword.add(generatePassword());
        }
        return randArrayPassword;
    }

}
