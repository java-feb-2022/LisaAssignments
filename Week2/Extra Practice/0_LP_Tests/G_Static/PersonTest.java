public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person(10, "Person1");
        Person person2 = new Person(5, "Person2");
        Person person3 = new Person(15, "Person3");
        System.out.println(Person.numberOfPeople);
    }
}


// It is important to note that class methods cannot access instance variables or instance methods directly. In addition, class methods cannot use the this keyword as there is no instance for this to refer to.
