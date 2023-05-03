import java.util.logging.Level;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class Controller 
{
    private static String selectedFigure;

    @FXML
    private Button circleButton;  
    
    @FXML
    private Button rectangleButton;

    @FXML
    private Button polygonButton;

    @FXML
    private AnchorPane anchorPane;
    
    public void onClickCircleButton(Event e)
    {
        MyLogger.logger.log(Level.INFO, "Circle button pressed");
        this.selectedFigure = "circle";
    }

    public void onClickRectangleButton(Event e)
    {
        MyLogger.logger.log(Level.INFO, "Rectangle button pressed");
        this.selectedFigure = "rectangle";
    }

    public void onClickPolygonButton(Event e)
    {
        MyLogger.logger.log(Level.INFO, "Polygon button pressed");
        this.selectedFigure = "polygon";
    }

    public void onClickAnchorPane(MouseEvent e)
    {
        System.out.println("dupa");
        MyPointer.addPoint(e.getX(), e.getY());
    }
}
