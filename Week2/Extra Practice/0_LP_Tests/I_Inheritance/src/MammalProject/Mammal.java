package MammalProject;

class Mammal{
    private boolean sleeping = false;
    public void regulateTemperature() {
        System.out.println("My temperature is just right for now.");
    }
    public void startSleeping() {
        sleeping = true;
        System.out.println("ZzZz");
    }
    public boolean isSleeping(){
        return sleeping;
    }
}

