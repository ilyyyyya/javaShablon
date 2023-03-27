package practica7.facade;

public class Facade {

    private final SubSystem1 subsystem1;
    private final SubSystem2 subsystem2;
    private final SubSystem3 subsystem3;

    public Facade() {
        subsystem1 = new SubSystem1();
        subsystem2 = new SubSystem2();
        subsystem3 = new SubSystem3();
    }

    public void init(){
        subsystem1.start();
        subsystem2.start();
        subsystem3.start();
    }

}
