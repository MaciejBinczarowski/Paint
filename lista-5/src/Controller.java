import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
    private Menu infoButton;
    
    @FXML
    private void onClickCircleButton(Event e)
    {

        // tutaj zacznij bo to tutaj nie może zostać
        // durniu
        
        MyLogger.logger.log(Level.INFO, "Circle button pressed");
        MyPointer.clearPoints();
        MyShapeController.setSelectedOption("circle");
    }

    @FXML
    private void onClickRectangleButton(Event e)
    {
        MyLogger.logger.log(Level.INFO, "Rectangle button pressed");
        MyPointer.clearPoints();
        MyShapeController.setSelectedOption("rectangle");
    }

    @FXML
    private void onClickPolygonButton(Event e)
    {
        MyLogger.logger.log(Level.INFO, "Polygon button pressed");
        MyPointer.clearPoints();
        MyShapeController.setSelectedOption("polygon");
        
    }

    @FXML
    private void onClickEditButton(Event event)
    {
        MyLogger.logger.log(Level.INFO, "Edit button pressed");
        MyPointer.clearPoints();
        MyShapeController.setSelectedOption("edit");
        MyShapeController.enableEdit();
    }

    @FXML
    private void onClickDrawingPane(MouseEvent e)
    {
        if (MyShapeController.getSelectedOption() == null || MyShapeController.getSelectedOption().equals("edit"))
        {
            MyLogger.logger.log(Level.INFO, "Nothing selected!");
            return;
        }

        if (MyShapeController.getSelectedOption().equals("edit"))
        {
            return;
        }

        MyPointer.addPoint(e.getX(), e.getY());
        // backgroundPane.getChildren().add(new Circle(e.getX(), e.getY(), 2)); // jak starczy czasu to sie tym zajmij
        MyShapeController.createShapeFromPoints(drawingPane);
    }

    @FXML
    private void onClickSave(Event e)
    {
        DataSerializer.serializeData(MyShapeController.getShapes());
    }

    @FXML
    private void onClickLoad(Event e)
    {
        ArrayList<HashMap> shapesProperties = DataSerializer.deserializeData("file.ser");
        MyShapeController.loadShapes(shapesProperties, drawingPane);
    }

    @FXML
    private void onClickInfo(Event e)
    {
        String infoText = "";

        try
        {
            FileReader fileReader = new FileReader("src/info.txt");
            System.out.println("jestem po filereader");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                infoText += line + "\n";
            }

            bufferedReader.close();
        }
        catch (IOException exception)
        {
            MyLogger.logger.log(Level.INFO, "File doesnt exist!" + exception.getMessage());
        }            
        
        MyLogger.logger.log(Level.INFO, "Info button pressed");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        System.out.println(infoText);
        alert.setContentText(infoText);

        alert.show();
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
