import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.logging.Level;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class App extends Application
{
    final private static ArrayList<MyShape> shapes = new ArrayList<MyShape>();
    final private static HashMap<String, MyShapeBuilder> myShapeBuildersMap = new HashMap<String, MyShapeBuilder>()
        {{
            put("circle", new MyCircleBuilder());
            put("rectangle", new MyRectangleBuilder());
            put("polygon", new MyPolygonBuilder());
        }};
    private static Controller appController;
    private static String selectedOption;
    public static void main(String[] args) throws Exception 
    {
        MyLogger.loggerConfig();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Pane root = fxmlLoader.load();

        appController = fxmlLoader.getController();
        appController.setProperties();

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }

    public static void createShapeFromPoints(Pane pane)
    {
        for (MyShape myShape : shapes) 
        {
            myShape.getShape().setDisable(true);
        }

        MyShape shape = myShapeBuildersMap.get(selectedOption).buildMyShape(MyPointer.getPointsX(), MyPointer.getPointsY());
        
        if (shape == null)
        {
            return;
        }

        MyShapeController.setEventHandlers(shape);
        shape.getShape().setDisable(true);
        shapes.add(shape);

        pane.getChildren().add(shape.getShape());
        MyPointer.clearPoints();
    }

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
}
