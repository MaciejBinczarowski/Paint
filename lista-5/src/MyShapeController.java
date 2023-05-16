import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * @class MyShapeController
 * 
 * @brief MyShapeController class is static class contains all static methods relative with controll
 *        shapes. It includes setting event handlers on each shape, building shapes and deserializing them.
 * 
 */

public class MyShapeController 
{
    //myShapeBuildersMap is a helper map
    final private static HashMap<String, MyShapeBuilder> myShapeBuildersMap = new HashMap<String, MyShapeBuilder>()
        {{
            put("circle", new MyCircleBuilder());
            put("rectangle", new MyRectangleBuilder());
            put("polygon", new MyPolygonBuilder());
        }};
    final private static ArrayList<MyShape> shapes = new ArrayList<MyShape>();
    private static String selectedOption;

    /**
     * @brief Sets all all necessary event handlers to controll each shape. Most important method
     * 
     * @param myShape - MyShape class object, especially myCircle, myRectangle, myPolygon, myShape is
     *                  a parent abstract class
     */
    public static void setEventHandlers(MyShape myShape, Pane drawingPane)
    {
        ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        MenuItem changeColorOption = new MenuItem("Change color", colorPicker);
        MenuItem deleteOption = new MenuItem("Delete");
        ContextMenu contextMenu = new ContextMenu(deleteOption, changeColorOption);

        // sets shape active after click
        // shows contextMenu on secondary button by the way
        myShape.getShape().setOnMouseClicked(event -> 
        {
            myShape.getShape().toFront();
            myShape.getShape().requestFocus();

            if (event.getButton() == MouseButton.SECONDARY)
            {
                contextMenu.show(myShape.getShape(), event.getScreenX(), event.getScreenY());
            }
        });

        // moves shapes after mouse drag
        myShape.getShape().setOnMouseDragged(event -> 
        {
            contextMenu.hide();
            if (event.getButton() == MouseButton.PRIMARY)
            {
                myShape.getShape().requestFocus();
                myShape.getShape().toFront();
                myShape.move(event.getSceneX(), event.getSceneY());
            }
        });

        // sets scale after scrolling
        // its defult shape's behavior on scroll, it changes while pressing control
        EventHandler<ScrollEvent> scaleHandler = new EventHandler<ScrollEvent>()
        {
            @Override
            public void handle(ScrollEvent event)
            {
                myShape.getShape().toFront();
                myShape.scale(event.getDeltaY());
            }
        };

        myShape.getShape().setOnScroll(scaleHandler);

        // sets rotate after scrolling
        // it enables while pressing control
        EventHandler<ScrollEvent> rotateHandler = new EventHandler<ScrollEvent>()
        {

            @Override
            public void handle(ScrollEvent event) 
            {
                myShape.getShape().toFront();
                myShape.rotate(event.getDeltaY());
                MyLogger.logger.log(Level.INFO, "Rotate mode");
            }
        };
        
        // changes on rotate mode after controll press
        myShape.getShape().setOnKeyPressed(event ->
        {
            MyLogger.logger.log(Level.INFO, "Trying to get into rotate mode");
            if (event.getCode() == KeyCode.CONTROL)
            {
                myShape.getShape().setOnScroll(rotateHandler);
            }
        });

        // changes on scale mode after controll release
        myShape.getShape().setOnKeyReleased(e ->
        {
            if (e.getCode() == KeyCode.CONTROL)
            {
                myShape.getShape().setOnScroll(scaleHandler);
            }
        });

        // changes color of shape relying on ColorPicker
        changeColorOption.setOnAction(event ->
        {
            myShape.changeColor(colorPicker.getValue());
        });

        deleteOption.setOnAction(event ->
        {
            MyLogger.logger.log(Level.INFO, "Deleting shape");
            drawingPane.getChildren().remove(myShape.getShape());
            shapes.remove(myShape);
        });

        // gives focus on shape under the mouse
        // it is required to recognize when controll is pressed on the shape
        myShape.getShape().setOnMouseEntered(event ->
        {
            myShape.getShape().requestFocus();
        });
    }

    /**
     * @brief creates shape from supplied points on drawnigPane
     * 
     * @param drawningPane - pane where shape will be drawn
     */
    public static void createShapeFromPoints(Pane drawningPane)
    {
        // disable event handlers on each shape while being in drawing mode
        for (MyShape myShape : shapes) 
        {
            myShape.getShape().setDisable(true);
        }

        MyShape shape = myShapeBuildersMap.get(selectedOption).buildMyShape(MyPointer.getPointsX(), MyPointer.getPointsY());
        
        // MyShapeBuilder returns null when there are not enough points to build specific shape
        if (shape == null)
        {
            return;
        }

        MyShapeController.setEventHandlers(shape, drawningPane);
        shape.getShape().setDisable(true);
        shapes.add(shape);

        drawningPane.getChildren().add(shape.getShape());
        MyPointer.clearPoints();
        MyPointer.clearVisualPoints(drawningPane);
    }

    /**
     * @brief builds shapes from all their specific properties from saved file
     * 
     * @param shapesProperties - array of maps of most important properties about each shape
     * @param drawningPane - pane where shape will be drawn
     */
    public static void loadShapes(ArrayList<HashMap> shapesProperties, Pane drawningPane)
    {
        // reset drawing pane
        shapes.clear();
        drawningPane.getChildren().clear();
        selectedOption = null;
        
        for (HashMap shapeProperties : shapesProperties) 
        {
            MyLogger.logger.log(Level.INFO, "Start loading");

            // whole data unpacking is done in MyShapeBuilder
            MyShape myShape = myShapeBuildersMap.get(shapeProperties.get("name")).loadMyShape(shapeProperties);
            MyShapeController.setEventHandlers(myShape, drawningPane);
            myShape.getShape().setDisable(true);
            drawningPane.getChildren().add(myShape.getShape());
            shapes.add(myShape);
        }
    }

    /**
     * @brief enable event handlers on each shape
     */
    public static void enableEdit()
    {
        for (MyShape myShape : shapes) 
        {
            myShape.getShape().setDisable(false);
        }
    }

    public static String getSelectedOption()
    {
        return selectedOption;
    }

    public static void setSelectedOption(String option)
    {
        selectedOption = option;
    }

    public static ArrayList<MyShape> getShapes()
    {
        return shapes;
    }
}
