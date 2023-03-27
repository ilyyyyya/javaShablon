package ru.mirea.abstract_factory;

public class IceCreamFactoryA implements IceCreamFactory{

    @Override
    public IceCreamCone createIceCreamCone() {
        return new IceCreamConA();
    }

    @Override
    public IceCreamSundae createIceCreamSundae() {
        return new IceCreamSundaeA();
    }
}
