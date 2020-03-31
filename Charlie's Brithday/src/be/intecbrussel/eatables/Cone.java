package be.intecbrussel.eatables;

public class Cone
        implements Eatables{

    private Flavor[] flavors;

    public Cone(){}

    public Cone(Flavor[] flavors) {
        this.flavors = flavors;
    }

    public Flavor[] getFlavors() {
        return flavors;
    }

    @Override
    public void eat() {
        System.out.println();
        for(Flavor flavor: flavors){
            System.out.print("mjam mjam mjam, " +flavor.name());
        }
    }
}
