public class Person {
    private int age;
    private String name;
    // public static int numberOfPeople = 0;
    private static int numberOfPeople = 0;

    //This is a static instance
    public Person(int ageParam, String nameParam) {
        age = ageParam;
        name = nameParam;
        numberOfPeople++;
    }

    // public int getAge() {
    //     this.age;
    // }

    // public static int peopleCount() {
    //     // static methods can only call other static methods - be careful
    //     return numberOfPeople;
    // }

    // public static String hello() {
    //     return "Hello";
    // }

    // public static int peopleCount() {
    //     //static methods can only call other static methods - be careful
    //     hello(); 
    //     return numberOfPeople;
    // }

    public static int peopleCount() {
        return numberOfPeople;
    }
}
