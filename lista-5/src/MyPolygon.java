import java.util.logging.Level;

import javafx.scene.shape.Polygon;

public class MyPolygon extends MyShape
{
    MyPolygon(double[] points)
    {
        super(new Polygon(points), "polygon");
        MyLogger.logger.log(Level.INFO, "Polygon, nie chce mi sie wypisywać tych punktów");
    }

    @Override
    public void move(double x, double y) 
    {
        MyLogger.logger.log(Level.CONFIG, "Polygon moved");
        shape.setLayoutX(x - shape.getLayoutBounds().getMinX() - 50);
        shape.setLayoutY(y - shape.getLayoutBounds().getMinY() - 50);
    }
    
}
