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
    }

    @Override
    public void scale(double deltaSize) 
    {
        shape.setScaleX(shape.getScaleX() * deltaSize);
        shape.setScaleY(shape.getScaleY() * deltaSize);
    }

    @Override
    public void rotate(double deltaAngle) 
    {
        
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
}
