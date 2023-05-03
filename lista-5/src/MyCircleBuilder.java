import java.util.ArrayList;

public class MyCircleBuilder extends MyShapeBuilder
{
    @Override
    public MyShape BuildMyShape(ArrayList<Double> pointsX, ArrayList<Double> pointsY) 
    {
        double x1 = pointsX.get(0);
        double x2 = pointsX.get(1);
        double y1 = pointsY.get(0);
        double y2 = pointsY.get(1);
        double radius = calculateRadius(x1, x2, y1, y2);

        return new MyCircle(radius, x1, y1);
    }

    private double calculateRadius(double x1, double x2, double y1, double y2)
    {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}
