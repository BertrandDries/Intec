package be.intecBrussel.the_notebook.entities.plant_entities;

public abstract class Plant {
    protected String name;
    protected int height;

    public Plant(String name) {
        this.name = name;
    }

    public Plant(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
