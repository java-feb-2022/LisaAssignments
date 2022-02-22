package MammalProject;

public class Bat extends Mammal {
	private int energyLvl = 300;
	public Bat () {
		super();
	}
	
	public void fly() {
		if(this.energyLvl<50) {
			System.out.println("The bat doesn't haven't enough energy to fly!");
		}
		else {
			energyLvl -= 50;
			System.out.println("This bat flew!");
		}
	}
	
	public void eatHumans() {
			energyLvl += 25;
			System.out.println("Bats love to eat. So it did.");
	}
	
	public void attackTown() {
		if(this.energyLvl<100) {
			System.out.println("The town is still intact. The bat refuses to move without energy.");
		}
		else {
			energyLvl -= 100;
			System.out.println("The town is scared of this bat! Consider this town pillaged.");
		}
	}
}