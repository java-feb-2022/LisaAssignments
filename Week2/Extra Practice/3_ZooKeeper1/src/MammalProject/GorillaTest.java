package MammalProject;

public class GorillaTest {
    public static void main(String[] args) {
    	
    	Mammal Guerilla = new Mammal(100);
    	Guerilla.displayEnergy();

    	Gorilla Bob = new Gorilla(100);
        Bob.throwSomething("banana");
        Bob.throwSomething("apple");
        Bob.throwSomething("baby");
        Bob.eatBanana();
        Bob.climb();
        Bob.displayEnergy();
    }
}