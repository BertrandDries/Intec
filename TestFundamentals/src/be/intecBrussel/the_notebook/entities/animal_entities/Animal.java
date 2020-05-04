package be.intecBrussel.the_notebook.entities.animal_entities;

public abstract class Animal {
    protected String name;
    protected double weight;
    protected double height;
    protected double lenght;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, double weight, double height, double lenght) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.lenght = lenght;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }
}
