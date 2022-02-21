package MammalProject;

public class Mammal{
	public int energyLvl;
	
	public Mammal(int energyParam) {
		this.energyLvl = energyParam;
	}
	
	public int displayEnergy() {
		System.out.printf("Energy level: %s",this.energyLvl);
		return energyLvl;
	}
}	
	