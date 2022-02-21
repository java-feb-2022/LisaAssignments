package MammalProject;

public class Mammal{
	int energyLvl = 100;

	public Mammal() {
	}
	
	public Mammal(int energy) {
		this.energyLvl=energy;
	}
	
	public int getEnergy() {
		return energyLvl;
	}
	
	public int displayEnergy() {
		System.out.printf("Energy level: %s",this.energyLvl);
		return energyLvl;
	}
}	
	