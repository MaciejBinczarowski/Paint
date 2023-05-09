import java.util.logging.Level;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MyCircleButton extends Button
{
    public MyCircleButton()
    {
        setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent e)
            {
            MyLogger.logger.log(Level.INFO, "Rectangle button pressed");
            MyPointer.clearPoints();
            MyShapeController.setSelectedOption("rectangle");
            }
        
        });
    }
}