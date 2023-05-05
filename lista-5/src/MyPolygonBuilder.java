import java.util.ArrayList;
import java.util.logging.Level;

public class MyPolygonBuilder extends MyShapeBuilder
{

    @Override
    public MyShape buildMyShape(ArrayList<Double> pointsX, ArrayList<Double> pointsY) 
    {
        if (MyPointer.getSize() != 6) // chuj wie czy działa, musze iść
        {
            return null;
        }

        double[] points = preparePoints(pointsX, pointsY);

        return new MyPolygon(points);
    }

    private double[] preparePoints(ArrayList<Double> pointsX, ArrayList<Double> pointsY)
    {
        double[] pointsArray = new double[2 * pointsX.size()];

        int index = 0;
        for (int i = 0; i < 2 * pointsX.size(); i += 2)
        {
            pointsArray[i] = pointsX.get(index);
            pointsArray[i + 1] = pointsY.get(index);
            index++;
            MyLogger.logger.log(Level.INFO, "Added point: (" + pointsArray[i] + ", " + pointsArray[i + 1] + ")");
        }

        return pointsArray;
    }
   
}
