import java.util.logging.Level;

import javafx.scene.shape.Circle;

public class MyCircle extends MyShape
{
    final private double radius;
    final private double centerX;
    final private double centerY;

    public MyCircle(double radius, double centerX, double centerY)
    {
        super(new Circle(centerX, centerY, radius), "circle");
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
        MyLogger.logger.log(Level.INFO, "Circle with radius = " + radius + " and center in (" + centerX + ", " + centerY + ")");
    }

    @Override
    public void move(double x, double y) 
    {
        MyLogger.logger.log(Level.INFO, "Circle moved");
        MyLogger.logger.log(Level.INFO, shape.getScaleX() + " " + shape.getScaleY());
        shape.setLayoutX(x - shape.getLayoutBounds().getMinX() - 50);
        shape.setLayoutY(y - shape.getLayoutBounds().getMinY() - 50);
    }

}
