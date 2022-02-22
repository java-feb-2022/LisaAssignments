package MammalProject;

public class Gorilla extends Mammal {
	public Gorilla(int energyLvl) {
		super(energyLvl);
	}
	public void throwSomething(String item) {
		System.out.printf("throws %s",item);
		energyLvl -= 5;
	}
	public void eatBanana() {
		System.out.println("eat banana");
		energyLvl += 10;
	}
	public void climb() {
		System.out.println("climbing");
		energyLvl -= 10;
	}
}