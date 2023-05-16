import java.util.ArrayList;
import java.util.logging.Level;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class MyPointer 
{
    private static ArrayList<Double> pointsX = new ArrayList<Double>();
    private static ArrayList<Double> pointsY = new ArrayList<Double>();
    private static ArrayList<MyVisualPoint> visualPoints = new ArrayList<MyVisualPoint>();

    public static void addPoint(double x, double y)
    {
        pointsX.add(x);
        pointsY.add(y);
        MyLogger.logger.log(Level.INFO, "Added (" + x + ", " + y + ") point");
    }

    public static ArrayList<Double> getPointsX()
    {
        return pointsX;
    }

    public static ArrayList<Double> getPointsY()
    {
        return pointsY;
    }

    public static void clearPoints()
    {
        MyLogger.logger.log(Level.INFO, "Removing " + pointsX.size() + " points");
        pointsX.clear();
        pointsY.clear();
    }

    public static int getSize()
    {
        int size = pointsX.size();
        MyLogger.logger.log(Level.INFO, "Size is " + size);
        return size;
    }

    public static void addVisualPoint(double x, double y, Pane pane)
    {
        MyVisualPoint visualPoint = new MyVisualPoint(x, y);
        visualPoints.add(visualPoint);
        pane.getChildren().addAll(visualPoint);
        MyLogger.logger.log(Level.INFO, "Visual point added");
    }

    public static void clearVisualPoints(Pane pane)
    {
        for (Circle visualPoint : visualPoints) 
        {
            pane.getChildren().remove(visualPoint);
        }
        visualPoints.clear();
    }
}
