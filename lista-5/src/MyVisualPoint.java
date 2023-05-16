import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyVisualPoint extends Circle
{
    private static double pointRadius = 1.0;

    public MyVisualPoint(double x, double y)
    {
        super(x, y, pointRadius);
        setStroke(Color.BLACK);
        setFill(Color.GREY);
    }
}
