public class TestGreetings {
    public static void main(String[] args) {

        //use dependency injection, an instance of another class (create a variable)
        Greetings greeterApp = new Greetings(); //1

        String dateMessage = greeterApp.getCurrentDate(); //2

        System.out.println(dateMessage); //3

    }
}
// 1. We are instantiating a new Greetings object. Now, all public methods of the Greetings class are available to that object.
// 2. Calling the getCurrentDate() method on the object.
// 3. Printing the currentDate string.



//DEPENDENCY INJECTION
    // another way to use external code from another file

// As long as both Greetings and TestGreetings files are in the same directory, you do not have to explicitly import one into another. Also, you can just run the javac compiler on TestGreetings, and it will compile both files for us.