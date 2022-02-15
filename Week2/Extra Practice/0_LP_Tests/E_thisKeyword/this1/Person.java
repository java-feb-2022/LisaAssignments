public class Person {
    private int age;
    private int cmHeight;
    private String name;


    // In this case, it must be the first statement in your constructor, and it will call the other constructor for you.
    public Person() {
        this(20, "John Doe", 171);
    }

    public Person(int age, String name, int cmHeight) {
        this.age = age;
        this.name = name;
        this.cmHeight = cmHeight;
    }
// ...
