package be.intecBrussel.the_notebook.entities.animal_entities;

import be.intecBrussel.the_notebook.entities.plant_entities.Plant;

import java.util.Set;

public class Omnivore extends Animal {
    private Set<Plant> plantDiet;
    private double maxFoodSize;

    public Omnivore(String name) {
        super(name);
    }

    public Omnivore(String name, double weight, double height, double lenght) {
        super(name, weight, height, lenght);
    }

    public Set<Plant> getPlantDiet() {
        return plantDiet;
    }

    public void setPlantDiet(Set<Plant> plantDiet) {
        this.plantDiet = plantDiet;
    }

    public double getMaxFoodSize() {
        return maxFoodSize;
    }

    public void setMaxFoodSize(double maxFoodSize) {
        this.maxFoodSize = maxFoodSize;
    }

    public void addPlantToDiet(Plant plant){
        plantDiet.add(plant);
    }

    public void printDiet(){
        plantDiet.forEach(System.out :: println);
    }

    public String toString() {
        return "Omnivore{" +
                ", maxFoodSize=" + maxFoodSize +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", lenght=" + lenght +
                '}';
    }
}
