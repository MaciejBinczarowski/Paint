import java.security.InvalidParameterException;
import java.util.ArrayList;

public class MyRectangleBuilder extends MyShapeBuilder 
{
    @Override
    public MyShape buildMyShape(ArrayList<Double> pointsX, ArrayList<Double> pointsY) 
    {
        if (pointsX.size() != 2)
        {
            return null;
        }

        double upperLeftX = pointsX.get(0);
        double upperLeftY = pointsY.get(0);
        double width = pointsX.get(1) - upperLeftX;
        double height = pointsY.get(1) - upperLeftY;

        if (width == 0)
        {
            throw new InvalidParameterException("width cannot equal 0");
        }

        if (height == 0)
        {
            throw new InvalidParameterException("height cannot equal 0");
        }

        if (width < 0)
        {
            upperLeftX = pointsX.get(1);
            width = Math.abs(width);
        }

        if (height < 0)
        {
            upperLeftY = pointsY.get(1);
            height = Math.abs(height);
        }

        MyRectangle myRectangle = new MyRectangle(upperLeftX, upperLeftY, width, height);

        ArrayList<Double> startingPointsX = new ArrayList<Double>(pointsX);
        ArrayList<Double> startingPointsY = new ArrayList<Double>(pointsY);
        myRectangle.setStartingPoints(startingPointsX, startingPointsY);

        return myRectangle;
    }

}
