package Polymorphism;

class CappuccinoMaker extends CoffeeMaker {
    private String milk;
    public CappuccinoMaker() {
        this.maxVolumeOz = 16;
        this.milk = "whole";
    }
                  
    public void brew(String beans) {
		super.brew(beans);
        System.out.println("Frothy!!!");
    }
                  
    public void clean(){
        System.out.println("Cleaning the froth!");
    }
}

