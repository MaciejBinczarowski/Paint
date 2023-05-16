import java.util.logging.Level;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.paint.Color;

public abstract class MyShapeBuilder 
{
    public abstract MyShape buildMyShape(ArrayList<Double> pointsX, ArrayList<Double> pointsY);

    public MyShape loadMyShape(HashMap<String, String> shapeProperties)
    {
        MyLogger.logger.log(Level.INFO, "I am in MyShapeBuilder");
        MyShape myShape = buildMyShape(DataMenager.convertPointsToDouble(shapeProperties.get("pointsXString")), DataMenager.convertPointsToDouble(shapeProperties.get("pointsYString")));
        MyLogger.logger.log(Level.INFO, "MyShape created");

        myShape.getShape().setScaleX(Double.parseDouble(shapeProperties.get("scale")));
        myShape.getShape().setScaleY(Double.parseDouble(shapeProperties.get("scale")));
        MyLogger.logger.log(Level.INFO, "Scale setted");

        myShape.getShape().setLayoutX(Double.parseDouble(shapeProperties.get("layoutX")));
        myShape.getShape().setLayoutY(Double.parseDouble(shapeProperties.get("layoutY")));
        MyLogger.logger.log(Level.INFO, "Layout setted");
        
        myShape.getShape().setRotate(Double.parseDouble(shapeProperties.get("rotateValue")));
        MyLogger.logger.log(Level.INFO, "Rotate setted");

        myShape.getShape().setFill(Color.web(shapeProperties.get("color")));

        return myShape;
    }
}
