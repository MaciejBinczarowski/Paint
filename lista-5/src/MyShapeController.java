import java.util.logging.Level;

import javafx.scene.input.KeyCode;

public class MyShapeController 
{
    public static void setEventHandlers(MyShape myShape)
    {
        myShape.getShape().setOnMouseClicked(event -> 
        {
            myShape.getShape().toFront();
            myShape.getShape().requestFocus();
        });

        myShape.getShape().setOnMouseDragged(event -> 
        {
            // tutaj coś nie działa

            // dobra już wiem co xd
            myShape.getShape().toFront();
            myShape.move(event.getSceneX(), event.getSceneY());
            
        });

        myShape.getShape().setOnScroll(event -> 
        {
            myShape.getShape().toFront();
            myShape.scale(event.getDeltaY());
        });

        myShape.getShape().setOnKeyPressed(event ->
        {
            MyLogger.logger.log(Level.INFO, "Trying to get into rotate mode");
            if (event.getCode() == KeyCode.CONTROL)
            {
                myShape.getShape().setOnScroll(event2 -> 
                {
                    myShape.getShape().toFront();
                    myShape.rotate(event2.getDeltaY());
                    MyLogger.logger.log(Level.INFO, "Rotate mode");
                });
            }
        });

        myShape.getShape().setOnKeyReleased(e ->
        {
            if (e.getCode() == KeyCode.CONTROL)
            {
                myShape.getShape().setOnScroll(event -> 
                {
                    myShape.getShape().toFront();
                    myShape.scale(event.getDeltaY());
                });
            }
        });
    }
}
