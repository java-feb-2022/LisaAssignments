class Person {
    private int age;
    private String name;

    public Person(int ageParam, String nameParam) {
        this.age = ageParam;
        this.name = nameParam;
    }

    public void objectMethods(Person anotherObject) {
        System.out.println("Class name: " + this.getClass().getSimpleName());
        System.out.println("toString: " + this.toString());
        System.out.println("Equals: " + this.equals(anotherObject));
    }
}

//.getClass(): returns a Class object that represents the object's current class.

// .equals(): compares two objects for equality and returns a boolean.

// .toString(): return a string representation of the object. If you want, you can override this method.