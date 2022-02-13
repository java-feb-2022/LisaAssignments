import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {
        
        //declare the type ArrayList <> says array
        //put parenthesis at the end, it's calling the function of an instance of an ArrayList
        ArrayList<Integer> myList = new ArrayList<Integer>();
        System.out.println(myList);
        
        //required reference error - Array lists can't hold primitive types (<int> doesn't work

        myList.add(10); //expands size
        myList.add(11);
        System.out.println(myList);

        // Getters and Setters - use .get() passing in index
        Integer num = myList.get(0); //gets element at index 0 in myList
        System.out.println(num);

        //Set index 0 to the number 9
        myList.set(0, 9); //index and what you want to set it to > overwrite
        System.out.println(myList);

        ArrayList<Object> things = new ArrayList<Object>();
        things.add(10);
        things.add("Hello");
        things.add(new ArrayList<Integer>());
        things.add(12.5);
        System.out.println(things);

    }
}
