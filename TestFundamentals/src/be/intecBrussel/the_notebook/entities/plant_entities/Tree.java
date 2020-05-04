package be.intecBrussel.the_notebook.entities.plant_entities;

public class Tree extends Plant {
    private LeafType leaftype;

    public Tree(String name) {
        super(name);
    }

    public Tree(String name, int height) {
        super(name, height);
    }

    public LeafType getLeaftype() {
        return leaftype;
    }

    public void setLeaftype(LeafType leaftype) {
        this.leaftype = leaftype;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "leeftype='" + leaftype + '\'' +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
