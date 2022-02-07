// Conditionals must always evaluate to a boolean value
    // Assignment Operators: = vs == //SET AS operator
    // Comparison Operators: == x != x < x >
// Logical Operators: 
    // && (AND)
        // age < 65 && age > 17;
    // || (OR) 
        // age < 10 || age > 65;
    // ! (NOT) 
        // !(age < 16);

public class Conditionals {
    public static void main(String[] args) {
        boolean isRaining = true;
        boolean isCold = true;
        if (isRaining) {
            System.out.println("Bring an umbrella.");
        }
        else if(isCold) {
            System.out.println("Wear a coat.");
        }
        else {
            System.out.println("Have fun!");
        }
    }
}
