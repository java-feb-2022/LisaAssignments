public class ArraysAndLists {
    public static void main(String[] args) {
        
        // create an array with length 5
        // declaration, initialization and adding elements or values
        int[] myArray = new int[5];

        myArray[0] = 4;
        myArray[1] = 4;
        myArray[2] = 4;
        myArray[3] = 4;
        myArray[4] = 4;

        int[] myArray2 = { 4, 8, 8, 5, 9 };

        for (int i = 0; i < myArray.length; i++) {
            System.out.println(myArray[i]);
        }

        for (int i = 0; i < myArray2.length; i++) {
            System.out.println(myArray2[i]);
        }
        
        String[] fruits = { "banana", "pear", "papaya", "kiwi" };
        // To swap the value at index 0 and index 3
        String temp = fruits[0]; // assigns temp to "banana"
        fruits[0] = fruits[3]; // { "kiwi", "pear", "papaya", "kiwi"}
        fruits[3] = temp; // { "kiwi", "pear", "papaya", "banana"}

        System.out.println(fruits.length); // 4
        // Array is currently { "kiwi", "pear", "papaya", "banana" }
        System.out.println(fruits[fruits.length - 1]); // "banana"



        for(int i=0; i<fruits.length; i++){
            System.out.println(fruits[i]);
        }

        // provides the string representation of that array, not an array [represents array]
        // System.out.println(myArray);
    }
}
