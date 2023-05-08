import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class DataMenager implements Serializable
{
    public String name;
    public double rotateValue;
    public double layoutX;
    public double layoutY;
    public ArrayList<Double> pointsX;
    public ArrayList<Double> pointsY;
    public double scaleX;
    public double scaleY;
    public String color;

    DataMenager(MyShape myShape)
    {
        name = myShape.getName();
        rotateValue = myShape.getShape().getRotate();
        layoutX = myShape.getShape().getLayoutX();
        layoutY = myShape.getShape().getLayoutY();
        pointsX = myShape.getStartingPointsX();
        pointsY = myShape.getStartingPointsY();
        scaleX = myShape.getShape().getScaleX();
        scaleY = myShape.getShape().getScaleY();
        color = myShape.getShape().getFill().toString();
    }
}
