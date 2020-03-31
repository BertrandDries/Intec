package be.intecbrussel.eatables;

public enum Flavor {
    STRAWBERRY(1),
    BANANANANANA(1.2),
    CHOCOLATE(1),
    VANILLA(1);

    public double priceMultiplier;

    Flavor(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }
}
