package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon
        implements Profitable,IceCreamSeller{

    private double totalProfit = 0;
    private PriceList priceList;

    public IceCreamSalon() {
        priceList = new PriceList(1.5, 2.5,2);
    }
    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }
    public IceCreamSalon(double x, double y, double z){
        priceList = new PriceList(x,y,z);
    }

    public Cone orderCone(Flavor[] flavors) {
        Cone cone = new Cone(flavors);
        double price = 0;
        for(Flavor flavor : flavors){
            price += priceList.getBallPrice(flavor);
        }
        addProfit(price);
        return cone;
    }
    public Magnum orderMagnum(MagnumType magnumType) {
        Magnum magnum = new Magnum(magnumType);
        addProfit(priceList.getMagnumPrice(magnumType));
        return null;
    }
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = new IceRocket();
        addProfit(priceList.getRocketPrice());
        return iceRocket;
    }

    public double getTotalProfit() {
        return totalProfit;
    }
    private void addProfit(double newProfit){
        totalProfit +=newProfit;
    }

    public String toString() {
        return "IceCreamSalon{" +
                "totalProfit=" + totalProfit +
                ", priceList=" + priceList.toString() +
                '}';
    }
}
