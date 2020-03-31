package be.intecbrussel.eatables;

public class Magnum
        implements Eatables {
    private MagnumType magnumType;

    public Magnum(){
    }

    public Magnum(MagnumType magnumType) {
        this.magnumType = magnumType;
    }

    @Override
    public void eat() {
        System.out.println("mjam mjam mjam, nice " + magnumType.name() + " Magnum");
    }

    public MagnumType getMagnumType() {
        return magnumType;
    }
}
