import java.lang.constant.DynamicCallSiteDesc;
import java.util.ArrayList;

public class Loops {

    //a for loops is a specialized while loop
    // The most common for statement you'll see is comprised of 4 key parts: the initialization; the termination; the increment; and the body statements.

    // WHILE LOOP
    // int i = 0;
    // while(i<7)
    // {
    //     System.out.println("foo");
    //     i++;
    // }

    // FOR LOOP
    // for(
    // int i = 0;i<7;i++)
    // {
    //     System.out.println("bar");
    // }

    //         ArrayList<String> dynamicArray = new ArrayList<String>();
    //         dynamicArray.add("hello");
    //         dynamicArray.add("world");
    //         dynamicArray.add("etc");
    //         for (int i = 0; i < dynamicArray.size(); i++){
    //             System.out.println(dynamicArray.get(i));
    // }

    
    //WHEN TO NOT USE THE ENHANCED LOOP
    //         ArrayList<String> snacks = new ArrayList<String> ();
    //         snacks.add("Apples");
    //         snacks.add("Pretzels");
    //         snacks.add("Almonds");
    //         snacks.add("Yogurt");
    //         for(String snack : snacks ) {
    //             if(snack.charAt(0) == 'A') {
    //                 snacks.remove(snack);
    //             }
    //         }
    //         // this will encounter an error like
    //         // Exception in thread "main" java.util.ConcurrentModificationException

    //INSTEAD:
    //     for(int i=0; i<snacks.size(); i++) {
    //     if(snacks.get(i).charAt(0) == 'A') {
    //         snacks.remove(i);
    //     }
    // }

}
