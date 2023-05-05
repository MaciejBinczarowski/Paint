import java.util.logging.Level;

import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MyShapeController 
{
    // public static void setContextMenu()
    // {
    //     contextMenu.getItems().addAll(menuItem);
    // }

    public static void setEventHandlers(MyShape myShape)
    {
        ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        MenuItem menuItem = new MenuItem("Change color", colorPicker);
        ContextMenu contextMenu = new ContextMenu(menuItem);

        myShape.getShape().setOnMouseClicked(event -> 
        {
            // myShape.getShape().setStroke(Color.AQUAMARINE);
            // myShape.getShape().setStrokeWidth(5);
            myShape.getShape().toFront();
            myShape.getShape().requestFocus();

            if (event.getButton() == MouseButton.SECONDARY)
            {
                contextMenu.show(myShape.getShape(), event.getScreenX(), event.getScreenY());
            }
        });

        myShape.getShape().setOnMouseDragged(event -> 
        {
            // tutaj coś nie działa

            // dobra już wiem co xd

            contextMenu.hide();
            if (event.getButton() == MouseButton.PRIMARY)
            {
                myShape.getShape().requestFocus();
                myShape.getShape().toFront();
                myShape.move(event.getSceneX(), event.getSceneY());
            }
        });

        myShape.getShape().setOnScroll(event -> 
        {
            myShape.getShape().toFront();
            myShape.scale(event.getDeltaY());
        });

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
        
        myShape.getShape().setOnKeyPressed(event ->
        {
            MyLogger.logger.log(Level.INFO, "Trying to get into rotate mode");
            if (event.getCode() == KeyCode.CONTROL)
            {
                myShape.getShape().setOnScroll(rotateHandler);
            }
        });

        myShape.getShape().setOnKeyReleased(e ->
        {
            if (e.getCode() == KeyCode.CONTROL)
            {
                myShape.getShape().setOnScroll(scaleHandler);
            }
        });

        menuItem.setOnAction(event ->
        {
            myShape.changeColor(colorPicker.getValue());
        });

        myShape.getShape().setOnMouseEntered(event ->
        {
            myShape.getShape().requestFocus();
        });
    }
}
