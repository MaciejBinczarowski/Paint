import java.util.logging.Level;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller 
{
    private String selectedFigure;

    @FXML
    private Button circleButton;  
    
    @FXML
    private Button rectangleButton;

    @FXML
    private Button polygonButton;

    @FXML
    private Pane pane;
    
    public void onClickCircleButton(Event e)
    {
        MyLogger.logger.log(Level.INFO, "Circle button pressed");
        MyPointer.clearPoints();
        App.selectedOption = "circle";
    }

    public void onClickRectangleButton(Event e)
    {
        MyLogger.logger.log(Level.INFO, "Rectangle button pressed");
        MyPointer.clearPoints();
        App.selectedOption = "rectangle";
    }

    public void onClickPolygonButton(Event e)
    {
        MyLogger.logger.log(Level.INFO, "Polygon button pressed");
        MyPointer.clearPoints();
        App.selectedOption = "polygon";
        
    }

    public void onClickEditButton(Event event)
    {
        MyLogger.logger.log(Level.INFO, "Edit button pressed");
        MyPointer.clearPoints();
        App.selectedOption = "edit";
        App.enableEdit();
    }

    public void onClickPane(MouseEvent e)
    {
        if (App.selectedOption == null || App.selectedOption.equals("edit"))
        {
            MyLogger.logger.log(Level.INFO, "Nothing selected!");
            return;
        }

        if (App.selectedOption.equals("edit"))
        {
            return;
        }

        MyPointer.addPoint(e.getX(), e.getY());
        // pane.getChildren().add(new Circle(e.getX(), e.getY(), 2)); // jak starczy czasu to sie tym zajmij
        App.createShapeFromPoints(pane);
    }
}
