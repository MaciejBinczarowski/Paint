import java.util.logging.Level;

import javafx.scene.shape.Circle;

public class MyCircle extends MyShape
{
    final private double radius;
    final private double centerX;
    final private double centerY;

    public MyCircle(double radius, double centerX, double centerY)
    {
        super(new Circle(radius), "Circle");
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
        MyLogger.logger.log(Level.INFO, "Circle with radius = " + radius + " and center in (" + centerX + ", " + centerY + ")");
    }

    @Override
    public void move(double x, double y) 
    {
        
    }
}