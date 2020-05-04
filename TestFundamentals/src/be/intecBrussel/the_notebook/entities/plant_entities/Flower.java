package be.intecBrussel.the_notebook.entities.plant_entities;

public class Flower extends Plant{
    private Scent scent;

    public Flower(String name) {
        super(name);
    }

    public Flower(String name, int height) {
        super(name, height);
    }

    public Scent getScent() {
        return scent;
    }

    public void setScent(Scent scent) {
        this.scent = scent;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "scent='" + scent + '\'' +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
