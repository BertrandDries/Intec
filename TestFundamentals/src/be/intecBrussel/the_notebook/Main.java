package be.intecBrussel.the_notebook;

import be.intecBrussel.the_notebook.entities.animal_entities.Carnivore;
import be.intecBrussel.the_notebook.entities.animal_entities.Herbivore;
import be.intecBrussel.the_notebook.entities.animal_entities.Omnivore;
import be.intecBrussel.the_notebook.entities.plant_entities.*;
import be.intecBrussel.the_notebook.service.ForestNoteBook;


public class Main {
    public static void main(String[] args) {
        ForestNoteBook maandagOchtend = new ForestNoteBook();

        Bush shrubbery = new Bush("shrubbery", 150);
        Tree bananatree = new Tree("BananaTree", 210);
        Flower rose = new Flower("rose", 25);
        Tree nuts = new Tree("nuts", 450);
        Weed nettle = new Weed("nettel", 120);
        rose.setScent(Scent.SWEET);

        Herbivore elephant = new Herbivore("Elephant", 1500, 2.7,4 );
        Herbivore antilope = new Herbivore("antilope");
        Herbivore rabbit = new Herbivore("Rabbit");
        Carnivore lion = new Carnivore("lion");
        Carnivore houseCat = new Carnivore("houseCat");
        Carnivore hyena = new Carnivore("Hyena");
        Omnivore pig = new Omnivore("Pig");
        Omnivore human = new Omnivore("Human");
        Omnivore bear = new Omnivore("bear");

        elephant.addPlantToDiet(shrubbery);
        elephant.addPlantToDiet(nuts);
        elephant.addPlantToDiet(bananatree);

        maandagOchtend.addAnimal(elephant);
        maandagOchtend.addAnimal(antilope);
        maandagOchtend.addAnimal(rabbit);
        maandagOchtend.addAnimal(lion);
        maandagOchtend.addAnimal(houseCat);
        maandagOchtend.addAnimal(hyena);
        maandagOchtend.addAnimal(pig);
        maandagOchtend.addAnimal(human);
        maandagOchtend.addAnimal(bear);

        maandagOchtend.addPlant(shrubbery);
        maandagOchtend.addPlant(rose);
        maandagOchtend.addPlant(nuts);
        maandagOchtend.addPlant(nettle);
        maandagOchtend.addPlant(bananatree);

        System.out.println(maandagOchtend.getAnimalCount());
        System.out.println(maandagOchtend.getPlantCount());

        //maandagOchtend.printNotebook();
        maandagOchtend.printNotebook2();
        maandagOchtend.sortAnimalsByName();
        maandagOchtend.sortPlantsByName();
        maandagOchtend.printNotebook2();
    }
}
