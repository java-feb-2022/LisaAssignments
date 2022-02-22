package MammalProject;

public class Gorilla extends Mammal {
	
	public void throwSomething(String item) {
		System.out.printf("throws %s",item);
		super.energyLvl -= 5;
	}
	public void eatBanana() {
		System.out.println("eat banana");
		this.energyLvl += 10;
	}
	public void climb() {
		System.out.println("climbing");
		energyLvl -= 10;
	}
}