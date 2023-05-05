import java.util.logging.Level;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public abstract class MyShape implements IShapeAction
{
    final protected Shape shape;
    final protected String name;

    MyShape(Shape shape, String name)
    {
        this.shape = shape;
        this.name = name;

        //Definitly change it idioto jebany
    }

    @Override
    public void scale(double deltaY) 
    {
        shape.setScaleX(shape.getScaleX() + deltaY * 0.001);
        shape.setScaleY(shape.getScaleY() + deltaY * 0.001);
    }

    @Override
    public void rotate(double deltaAngle) 
    {
        shape.setRotate(shape.getRotate() + deltaAngle);
    }

    @Override
    public void changeColor(Color color) 
    {
        shape.setFill(color);
    }

    public Shape getShape()
    {
        return shape;
    }

    public String getName() 
    {
        return name;
    }

}
