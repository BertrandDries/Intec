package be.intecBrussel.the_notebook.service;

import be.intecBrussel.the_notebook.entities.animal_entities.Animal;
import be.intecBrussel.the_notebook.entities.animal_entities.Carnivore;
import be.intecBrussel.the_notebook.entities.animal_entities.Herbivore;
import be.intecBrussel.the_notebook.entities.animal_entities.Omnivore;
import be.intecBrussel.the_notebook.entities.plant_entities.Plant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ForestNoteBook {
    private int animalCount = 0;
    private int plantCount = 0;
    private List<Animal> animals = new ArrayList<>();
    private List<Plant> plants = new ArrayList<>();
    private List<Herbivore> herbivores = new ArrayList<>();
    private List<Omnivore> omnivores = new ArrayList<>();
    private List<Carnivore> carnivores = new ArrayList<>();

    public List<Herbivore> getHerbivores() {
        return herbivores;
    }

    public void setHerbivores(List<Herbivore> herbivores) {
        this.herbivores = herbivores;
    }

    public List<Omnivore> getOmnivores() {
        return omnivores;
    }

    public void setOmnivores(List<Omnivore> omnivores) {
        this.omnivores = omnivores;
    }

    public List<Carnivore> getCarnivores() {
        return carnivores;
    }

    public void setCarnivores(List<Carnivore> carnivores) {
        this.carnivores = carnivores;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public int getPlantCount() {
        return plantCount;
    }

    public void addNewAnimal( Animal newAnimal){
       /* AtomicBoolean present = new AtomicBoolean(false);
        animals.forEach(animal -> {
           if(animal.getName().equals(newAnimal.getName())){
               present.set(true);
           }
        });
        if(!present.get()){
            animalCount++;
            animals.add(newAnimal);
            switch( newAnimal.getClass().getName()){
                case "Omnivore" : omnivores.add((Omnivore) newAnimal); break;
                case "Herbivore" : herbivores.add((Herbivore) newAnimal); break;
                case "Carnivore" : carnivores.add((Carnivore) newAnimal); break;
            }
        }*/
        if(!animals.contains(newAnimal)){
            animalCount++;
            animals.add(newAnimal);
            switch( newAnimal.getClass().getName()){
                case "Omnivore" : omnivores.add((Omnivore) newAnimal); break;
                case "Herbivore" : herbivores.add((Herbivore) newAnimal); break;
                case "Carnivore" : carnivores.add((Carnivore) newAnimal); break;
            }
        }
    }

    public void addAnimal(Herbivore animal){
        if(!animals.contains(animal)){
            animalCount++;
            animals.add(animal);
            herbivores.add(animal);
        }
    }
    public void addAnimal(Carnivore animal){
        if(!animals.contains(animal)){
            animalCount++;
            animals.add(animal);
            carnivores.add(animal);
        }
    }
    public void addAnimal(Omnivore animal){
        if(!animals.contains(animal)){
            animalCount++;
            animals.add(animal);
            omnivores.add(animal);
        }
    }

    public void addPlant( Plant newPlant){
        if(!plants.contains(newPlant)){
            plantCount++;
            plants.add(newPlant);
        }
    }

    public void printNotebook(){
        System.out.println("Herbivores:");
        herbivores.forEach(System.out :: println);
        System.out.println("Omnivores:");
        omnivores.forEach(System.out :: println);
        System.out.println("Carnivores:");
        carnivores.forEach(System.out :: println);
        System.out.println("Plants:");
        plants.forEach(System.out :: println);
    }
    public void printNotebook2(){
        System.out.println("animals:");
        animals.forEach(System.out :: println);
        System.out.println("Plants:");
        plants.forEach(System.out :: println);
    }

    public void sortAnimalsByName(){
        Collections.sort(animals, new Comparator<Animal>() {
            @Override
            public int compare(Animal animal1, Animal animal2) {
                return animal1.getName().compareToIgnoreCase(animal2.getName());
            }
        });
    }

    public void sortAnimalsByHeight(){
        Collections.sort(animals, new Comparator<Animal>() {
            @Override
            public int compare(Animal animal1, Animal animal2) {
                if(animal1.getHeight()-animal2.getHeight()<=0){
                    return  -1;
                }
                else return +1;
            }
        });
    }

    public void sortPlantsByName(){
        Collections.sort(plants, new Comparator<Plant>() {
            @Override
            public int compare(Plant plant1, Plant plant2) {
                return plant1.getName().compareToIgnoreCase(plant2.getName());
            }
        });
    }

    public void sortPlantsByHeight(){
        Collections.sort(plants, new Comparator<Plant>() {
            @Override
            public int compare(Plant plant1, Plant plant2) {
                if(plant1.getHeight()-plant2.getHeight()<=0){
                    return  -1;
                }
                else return +1;
            }
        });
    }

}
