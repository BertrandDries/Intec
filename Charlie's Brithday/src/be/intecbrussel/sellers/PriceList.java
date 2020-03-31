package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Flavor;
import be.intecbrussel.eatables.MagnumType;

public class PriceList   {
    private double ballPrice;
    private double magnumStandardPrice;
    private double rocketPrice;

    public PriceList(){

    }

    public PriceList(double ballPrice, double magnumStandardPrice, double rocketPrice) {
        this.ballPrice = ballPrice;
        this.magnumStandardPrice = magnumStandardPrice;
        this.rocketPrice = rocketPrice;
    }

    public void setBallPrice(double ballPrice) {
        this.ballPrice = ballPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) {
        this.magnumStandardPrice = magnumStandardPrice;
    }

    public void setRocketPrice(double rocketPrice) {
        this.rocketPrice = rocketPrice;
    }

    public double getBallPrice(Flavor flavor) {
        return ballPrice*flavor.priceMultiplier;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public double getMagnumPrice(MagnumType magnumType) {
        return magnumStandardPrice*magnumType.magnumPriceMultiplier;
    }

    @Override
    public String toString() {
        return "PriceList{" +
                "ballPrice=" + ballPrice +
                ", magnumStandardPrice=" + magnumStandardPrice +
                ", rocketPrice=" + rocketPrice +
                '}';
    }
}
