import java.util.HashMap;
import java.util.Set;
import javax.swing.plaf.basic.BasicSliderUI.TrackListener;

public class Hashmatique {
// Create a trackList of type HashMap
// Add in at least 4 songs that are stored by title
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Self Esteem", "...I'm just a sucker with no self-esteem");
        trackList.put("Love Hurts", "Tonight we drink to youth...");
        trackList.put("Parade", "It won't rain on my parade");
        trackList.put("This Ain't A Scene, It's An Arms Race", "This ain't a scene, it's a goddamn arms race");

        // Pull out one of the songs by its track title
        String title = trackList.get("Love Hurts");
        System.out.println("Track: " + title);

        // Print out all the track names and lyrics in the format Track:Lyrics
        Set<String> keys = trackList.keySet();
        for (String key : keys) {
            System.out.println(key);
            System.out.println(trackList.get(key));
        }
    }
}
