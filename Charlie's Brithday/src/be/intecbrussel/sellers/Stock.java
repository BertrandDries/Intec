package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Flavor;
import be.intecbrussel.eatables.Magnum;

public class Stock {
    private int rocketStock;

    private int milkChocolateMagnumStock;
    private int whiteChocolateMagnumStock;
    private int blackChocolateMagnumStock;

    private int vanillaStock;
    private int chocolateStock;
    private int strawberryStock;
    private int bananaStock;

    public Stock() {
    }
    public Stock(int rocketStock, int milkChocolateMagnumStock, int whiteChocolateMagnumStock, int blackChocolateMagnumStock, int vanillaStock, int chocolateStock, int strawberryStock, int bananaStock) {
        this.rocketStock = rocketStock;
        this.milkChocolateMagnumStock = milkChocolateMagnumStock;
        this.whiteChocolateMagnumStock = whiteChocolateMagnumStock;
        this.blackChocolateMagnumStock = blackChocolateMagnumStock;
        this.vanillaStock = vanillaStock;
        this.chocolateStock = chocolateStock;
        this.strawberryStock = strawberryStock;
        this.bananaStock = bananaStock;
    }

    //getters and setters

    public int getRocketStock() {
        return rocketStock;
    }
    public int getMilkChocolateMagnumStock() {
        return milkChocolateMagnumStock;
    }
    public int getWhiteChocolateMagnumStock() {
        return whiteChocolateMagnumStock;
    }
    public int getBlackChocolateMagnumStock() {
        return blackChocolateMagnumStock;
    }
    public int getVanillaStock() {
        return vanillaStock;
    }
    public int getChocolateStock() {
        return chocolateStock;
    }
    public int getStrawberryStock() {
        return strawberryStock;
    }
    public int getBananaStock() {
        return bananaStock;
    }

    public void setRocketStock(int rocketStock) {
        try {
            if(rocketStock>=0) this.rocketStock = rocketStock;
            else throw new Exception("Sorry, not in stock.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setMagnumStock(Magnum magnum) {
        try{
            switch (magnum.getMagnumType()){
                case BLACKCHOCOLATE:setblackChocolateMagnumStock(--this.blackChocolateMagnumStock);
                case MILKCHOCOLATE:setMilkChocolateMagnumStock(--this.milkChocolateMagnumStock);
                case WHITECHOCOLATE:setWhiteChocolateMagnumStock(--this.whiteChocolateMagnumStock);
            }
        }
         catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void setMilkChocolateMagnumStock(int milkChocolateMagnumStock) throws Exception {
        try {
            if(milkChocolateMagnumStock>=0) this.milkChocolateMagnumStock = milkChocolateMagnumStock;
            else throw new Exception("Sorry, not in stock.");
        }
        catch (Exception e) {
           throw e;
        }
    }
    public void setWhiteChocolateMagnumStock(int whiteChocolateMagnumStock) throws Exception {
        try {
            if(whiteChocolateMagnumStock>=0)  this.whiteChocolateMagnumStock = whiteChocolateMagnumStock;
            else throw new Exception("Sorry, not in stock.");
        }
        catch (Exception e) {
           throw e;
        }
    }
    public void setblackChocolateMagnumStock(int darkChocolateMagnumStock) throws Exception{
            try {
                if(darkChocolateMagnumStock>=0)  this.blackChocolateMagnumStock = darkChocolateMagnumStock;
                else throw new Exception("Sorry, not in stock.");
            }
            catch (Exception e) {
                throw e;
            }
    }

    public void setConeStock(Cone cone){
        try{
            for( Flavor flavor : cone.getFlavors()){
                switch (flavor){
                    case STRAWBERRY: setStrawberryStock(--this.strawberryStock);
                    case VANILLA: setVanillaStock(--this.vanillaStock);
                    case CHOCOLATE: setChocolateStock(--this.chocolateStock);
                    case BANANANANANA: setBananaStock(--this.bananaStock);
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void setVanillaStock(int vanillaStock) throws Exception {
        try {
            if(vanillaStock>=0)   this.vanillaStock = vanillaStock;
            else throw new Exception("Sorry, not in stock.");
        }
        catch (Exception e) {
            throw e;
        }
    }
    public void setChocolateStock(int chocolateStock) throws Exception {
        try {
            if(chocolateStock>=0) this.chocolateStock = chocolateStock;
            else throw new Exception("Sorry, not in stock.");
        }
        catch (Exception e) {
            throw e;
        }
    }
    public void setStrawberryStock(int strawberryStock) throws Exception {
        try {
            if(strawberryStock>=0) this.strawberryStock = strawberryStock;
            else throw new Exception("Sorry, not in stock.");
        }
        catch (Exception e) {
            throw e;
        }
    }
    public void setBananaStock(int bananaStock) throws Exception {
        try {
            if(bananaStock>=0) this.bananaStock = bananaStock;
            else throw new Exception("Sorry, not in stock.");
        }
        catch (Exception e) {
            throw e;
        }
    }
}
