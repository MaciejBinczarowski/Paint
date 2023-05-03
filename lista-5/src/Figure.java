import java.util.logging.Level;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public abstract class Figure implements IFigure 
{
    protected Shape figure;
    protected String name;
    protected String color;

    public Figure(Shape figure, String name)
    {
        this.figure = figure;
        this.name = name;
        MyLogger.logger.log(Level.INFO, name + " created");
        
    }
    
}
