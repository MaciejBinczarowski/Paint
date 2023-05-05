import java.util.ArrayList;
import java.util.logging.Level;

public class MyPointer 
{
    private static ArrayList<Double> pointsX = new ArrayList<Double>();
    private static ArrayList<Double> pointsY = new ArrayList<Double>();

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
}
