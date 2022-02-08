public class StringDemo {
    public static void main(String[] args) {
        String ninja1 = "Coding Dojo is Awesome";
        int length = ninja1.length();
        System.out.println("String Length is : " + length);
        
        //CONCAT
        String string1 = "My name is ";
        String string2 = "Michael";
        String string3 = string1.concat(string2);
        System.out.println(string3);
        // will output My name is Michael

        //FORMAT
        String ninja2 = String.format("Hi %s, you owe me $%.2f !", "Jack", 25.0);
        System.out.println(ninja2);
        // Will print out Hi Jack, you owe me $25.00 !
        // Where %s is expecting a string
        // And %.2f is expecting a float data type. The value 2 will just place two
        // values to right of the decimal point.

        //INDEXOF
        String ninja3 = "Welcome to Coding Dojo!";
        int a = ninja3.indexOf("Coding"); // a is 11
        int b = ninja3.indexOf("co"); // b is 3
        int c = ninja3.indexOf("pizza"); // c is -1, "pizza" is not found

        //TRIM
        String sentence = "   spaces everywhere!   ";
        System.out.println(sentence.trim());

        //UPPERCASE AND LOWERCASE
        String a1 = "HELLO";
        String b1 = "world";
        System.out.println(a1.toLowerCase()); // hello
        System.out.println(b1.toUpperCase()); // WORLD

        //EQUALITY
        // Normal string assignment
        String a2 = "same string";
        String b2 = "same string";
        System.out.println(a2 == b2); // true
        // Creating new strings as separate objects (another way to create a String)
        a2 = new String("same letters");
        System.out.println(a2);
        b2 = new String("same letters");
        System.out.println(b2);
        System.out.println(a2 == b2); // false. Not the same object in memory.
        System.out.println(a2.equals(b2)); // true. same exact characters.

        // When we use == in Java with objects, we are comparing if both variables point to the same address and the same object in memory.

        String a3 = new String("Dojo");
        System.out.println(a3 == "Dojo");
        // surprisingly this will print out `false`

        String a4 = new String("Dojo");
        System.out.println(a4.equals("Dojo"));
        // this actually will print out `true`
    }
}
