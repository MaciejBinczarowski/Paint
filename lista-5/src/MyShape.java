import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public abstract class MyShape implements IShapeAction
{
    final protected Shape shape;
    final protected String name;
    protected ArrayList<Double> startingPointsX;
    protected ArrayList<Double> startingPointsY;

    MyShape(Shape shape, String name)
    {
        this.shape = shape;
        this.name = name;
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
        shape.setRotate(shape.getRotate() + deltaAngle * 0.1);
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

    public void setStartingPoints(ArrayList<Double> startingPointsX, ArrayList<Double> startingPointsY)
    {
        this.startingPointsX = startingPointsX;
        this.startingPointsY = startingPointsY;
    }

    public ArrayList<Double> getStartingPointsX()
    {
        return this.startingPointsX;
    }

    public ArrayList<Double> getStartingPointsY()
    {
        return this.startingPointsY;
    }
}
