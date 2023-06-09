import java.util.logging.Level;

import javafx.scene.shape.Rectangle;

public class MyRectangle extends MyShape
{
    private double upperLeftX;
    private double upperLeftY;
    private double width;
    private double height;

    // Constructor that creates rectangle with required cordinates and measurements and give it to parent abstract class MyShape
    MyRectangle(double upperLeftX, double upperLeftY, double width, double height)
    {
        super(new Rectangle(upperLeftX, upperLeftY, width, height), "rectangle");
        this.upperLeftX = upperLeftX;
        this.upperLeftY = upperLeftY;
        this.width = width;
        this.height = height;
        MyLogger.logger.log(Level.INFO, "Created " + height + "x" + width + " rectangle on (" + upperLeftX + ", " + upperLeftY + ") (left corner)");
    }

    @Override
    public void move(double x, double y) 
    {
        // x = x - shape.getLayoutBounds().getMinX() - 50;
        // x = x < -190 ? -190 : x;
        MyLogger.logger.log(Level.INFO, "Circle moved");
        shape.setLayoutX(x - shape.getLayoutBounds().getMinX() - 50);
        shape.setLayoutY(y - shape.getLayoutBounds().getMinY() - 50);
    }
}
