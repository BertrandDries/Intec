package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamCar
        implements Profitable,IceCreamSeller {

    private double totalProfit = 0;
    private PriceList priceList;
    private Stock stock;

    public IceCreamCar(Stock stock) {
        this.stock = stock;
    }

    public Cone orderCone(Flavor[] flavors) {
        Cone cone = new Cone(flavors);
        stock.setConeStock(cone);
        double price = 0;
        for(Flavor flavor : flavors){
            price += priceList.getBallPrice(flavor);
        }
        addProfit(price);
        return cone;
    }
    public Magnum orderMagnum(MagnumType magnumType) {
        Magnum magnum = new Magnum(magnumType);
        stock.setMagnumStock(magnum);
        addProfit(priceList.getMagnumPrice(magnumType));
        return null;
    }
    public IceRocket orderIceRocket() {
        IceRocket iceRocket = new IceRocket();
        stock.setRocketStock(stock.getRocketStock()-1);
        addProfit(priceList.getRocketPrice());
        return iceRocket;
    }

    public double getTotalProfit() {
        return totalProfit;
    }
    private void addProfit(double newProfit){
        totalProfit +=newProfit;
    }
}
