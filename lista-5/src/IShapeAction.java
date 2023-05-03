import javafx.scene.paint.Color;

public interface IShapeAction 
{
    public void move(double x, double y);

    public void rotate(double deltaAngle);

    public void scale(double deltaSize);

    public void changeColor(Color color);  
      
}
