import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class DataMenager implements Serializable
{
    public static HashMap<String, String> prepareShapeProperties(MyShape myShape)
    {
        HashMap<String, String> shapeProperties = new HashMap<>();

        System.out.println("Przygotowuje dane");
        String name = myShape.getName();
        String rotateValue = Double.toString(myShape.getShape().getRotate());
        String layoutX = Double.toString(myShape.getShape().getLayoutX());
        String layoutY = Double.toString(myShape.getShape().getLayoutY());
        String pointsXString = "";
        String pointsYString = "";
        ArrayList<Double> pointsX = myShape.getStartingPointsX();
        ArrayList<Double> pointsY = myShape.getStartingPointsY();
        String scale = Double.toString(myShape.getShape().getScaleX());
        String color = myShape.getShape().getFill().toString();

        for (double pointX : pointsX) 
        {
         pointsXString += pointX + ", ";   
        }

        for (double pointY : pointsY) 
        {
         pointsYString += pointY + ", ";   
        }

        shapeProperties.put("name", name);
        shapeProperties.put("rotateValue", rotateValue);
        shapeProperties.put("layoutX", layoutX);
        shapeProperties.put("layoutY", layoutY);
        shapeProperties.put("pointsXString", pointsXString);
        shapeProperties.put("pointsYString", pointsYString);
        shapeProperties.put("scale", scale);
        shapeProperties.put("color", color);

        return shapeProperties;

    }

    public static ArrayList<Double> convertPointsToDouble(String stringPoints)
    {
        ArrayList<Double> points = new ArrayList<Double>();

        String[] stripedStringPoints = stringPoints.split(", ");
        for (String point : stripedStringPoints) 
        {
            points.add(Double.parseDouble(point));
            System.out.println(point);    
        }
        return points;
    }
}
