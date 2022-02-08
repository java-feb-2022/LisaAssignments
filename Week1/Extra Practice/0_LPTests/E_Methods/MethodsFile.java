public class MethodsFile {
    
    //void gives you permission to not return anything
    // Signature (every method's signature of guestGreeting(String, String))
        //Name of method + parameter types
        
    // name of function and parameters of function (greeter (String name))
    public String greeter(String name, Date date) {
        return "Hello World!";
    }

    public void coolMethodName(int someNumber, String someString) {
        System.out.println("Hello World");
    }   

    public String greeter(String name) {
        return "Hello World!";
    }

    // METHOD OVERLOADING - same function, different parameters
    // ...
    public String guestGreeting(String name) {
        return ("Hello World!");
    }

    // ...
    public String guestGreeting(String name, String dayPeriod) {
        return ("Hello World!");
    }
    // ...


}
