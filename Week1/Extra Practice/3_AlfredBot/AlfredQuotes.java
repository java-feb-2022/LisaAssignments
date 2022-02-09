import java.util.Date;
import java.util.Calendar;

public class AlfredQuotes {

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hey, what's up? I am Alfred-o";
    }

    public String guestGreeting(String name) {
        String guestGreet = String.format("Hello %s, are you having loads of fun? Because I am!", name);
        return guestGreet;
    }

    public String dateAnnouncement() {
        Date today = Calendar.getInstance().getTime();
        String announcement = String.format("Hello! Today is %s.", today); 
        return announcement;
    }

    public String respondBeforeAlexis(String conversation) {
        
        if (conversation.indexOf("Alexis") > -1) {
            return "How do you get Pikachu on the bus? You pok-em-on!";
        }
        if (conversation.indexOf("Alfred") > -1) {
            return "Where's your yo-yo? No, suck it";
        }
        return "Well, never mind";
    }

    // NINJA BONUS
    // See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have
    // learned!
}
