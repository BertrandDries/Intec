package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public interface IceCreamSeller {
    public Cone orderCone(Flavor[] flavors);
    public Magnum orderMagnum(MagnumType magnumType);
    public IceRocket orderIceRocket();
}
