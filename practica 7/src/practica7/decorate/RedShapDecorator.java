package practica7.decorate;

import practica7.decorate.Shape;
import practica7.decorate.ShapeDecorator;

public class RedShapDecorator extends ShapeDecorator {

    public RedShapDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("red");
    }
    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

}
