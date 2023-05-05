import java.util.logging.Level;
import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public abstract class MyShapeBuilder 
{
    public abstract MyShape buildMyShape(ArrayList<Double> pointsX, ArrayList<Double> pointsY);
}
