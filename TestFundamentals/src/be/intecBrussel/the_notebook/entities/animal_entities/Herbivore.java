package be.intecBrussel.the_notebook.entities.animal_entities;

import be.intecBrussel.the_notebook.entities.plant_entities.Plant;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Herbivore extends Animal {
    private Set<Plant> plantDiet = new HashSet<>();

    public Herbivore(String name) {
        super(name);
    }

    public Herbivore(String name, double weight, double height, double lenght) {
        super(name, weight, height, lenght);
    }

    public Set<Plant> getPlantDiet() {
        return plantDiet;
    }

    public void setPlantDiet(Set<Plant> plantDiet) {
        this.plantDiet = plantDiet;
    }

    public void addPlantToDiet(Plant plant){
        plantDiet.add(plant);
    }

    public void printDiet(){
       plantDiet.forEach(System.out :: println);
    }

    public String toString() {
        return "Herbivore{" +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", lenght=" + lenght +
                '}';
    }
}
