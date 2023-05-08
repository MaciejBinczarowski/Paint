import java.util.ArrayList;
import java.util.logging.Level;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public abstract class MyShape implements IShapeAction, java.io.Serializable
{
    final protected Shape shape;
    final protected String name;
    protected ArrayList<Double> startingPointsX;
    protected ArrayList<Double> startingPointsY;

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

    //Weż ty przemyśl swoje zachowanie i zmień to
    // zmądrzałem, przeciąż metody w MyShapeBuilder
    //200 IQ
    //
    // w sumie to nie wiem co miałem na myśli xd

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
