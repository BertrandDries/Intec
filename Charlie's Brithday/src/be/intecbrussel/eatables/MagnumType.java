package be.intecbrussel.eatables;

public enum MagnumType {
    MILKCHOCOLATE(1),
    WHITECHOCOLATE(1.2),
    BLACKCHOCOLATE(1.1);

    public double magnumPriceMultiplier;

    MagnumType(double magnumPriceMultiplier) {
        this.magnumPriceMultiplier = magnumPriceMultiplier;
    }
}
