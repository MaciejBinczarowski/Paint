import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Controller 
{
    @FXML
    private Button circleButton;  
    
    @FXML
    private Button rectangleButton;

    @FXML
    private Button polygonButton;

    @FXML
    private Pane backgroundPane;

    @FXML
    private MenuBar menuBar;

    @FXML
    private HBox buttonPane;

    @FXML
    private Pane drawingPane;

    @FXML
    private MenuItem saveButton;
    
    @FXML
    private void onClickCircleButton(Event e)
    {

        // tutaj zacznij bo to tutaj nie może zostać
        // durniu
        
        MyLogger.logger.log(Level.INFO, "Circle button pressed");
        MyPointer.clearPoints();
        App.setSelectedOption("circle");
    }

    @FXML
    private void onClickRectangleButton(Event e)
    {
        MyLogger.logger.log(Level.INFO, "Rectangle button pressed");
        MyPointer.clearPoints();
        App.setSelectedOption("rectangle");
    }

    @FXML
    private void onClickPolygonButton(Event e)
    {
        MyLogger.logger.log(Level.INFO, "Polygon button pressed");
        MyPointer.clearPoints();
        App.setSelectedOption("polygon");
        
    }

    @FXML
    private void onClickEditButton(Event event)
    {
        MyLogger.logger.log(Level.INFO, "Edit button pressed");
        MyPointer.clearPoints();
        App.setSelectedOption("edit");
        App.enableEdit();
    }

    @FXML
    private void onClickDrawingPane(MouseEvent e)
    {
        if (App.getSelectedOption() == null || App.getSelectedOption().equals("edit"))
        {
            MyLogger.logger.log(Level.INFO, "Nothing selected!");
            return;
        }

        if (App.getSelectedOption().equals("edit"))
        {
            return;
        }

        MyPointer.addPoint(e.getX(), e.getY());
        // backgroundPane.getChildren().add(new Circle(e.getX(), e.getY(), 2)); // jak starczy czasu to sie tym zajmij
        App.createShapeFromPoints(drawingPane);
    }

    @FXML
    private void onClickSave(Event e)
    {
        DataSerializer.serializeData(App.getShapes());
    }

    @FXML
    private void onClickLoad(Event e)
    {
        ArrayList<HashMap> shapesProperties = DataSerializer.deserializeData("file.ser");
        App.loadShapes(shapesProperties, drawingPane);
    }

    @FXML
    private void onClickInfo(Event e)
    {

    }

    public void setProperties()
    {
        menuBar.prefWidthProperty().bind(backgroundPane.widthProperty());
        Rectangle clip = new Rectangle(0, 0, backgroundPane.getPrefWidth(), backgroundPane.getPrefHeight());
        drawingPane.prefWidthProperty().bind(backgroundPane.widthProperty());
        drawingPane.prefHeightProperty().bind(backgroundPane.heightProperty());
        clip.widthProperty().bind(backgroundPane.widthProperty());
        clip.heightProperty().bind(backgroundPane.heightProperty());

        drawingPane.setClip(clip);
        MyLogger.logger.log(Level.INFO, "Created clip");
        

        buttonPane.prefWidthProperty().bind(backgroundPane.widthProperty());
    }
}
