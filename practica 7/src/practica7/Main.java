package practica7;

import practica7.decorate.Circle;
import practica7.decorate.RedShapDecorator;
import practica7.decorate.Shape;
import practica7.decorate.Triangle;
import practica7.facade.Facade;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapDecorator(new Circle());
        Shape redTriangle = new RedShapDecorator(new Triangle());

        circle.draw();
        redCircle.draw();
        redTriangle.draw();

        Facade facade = new Facade();
        facade.init();


    }
}
