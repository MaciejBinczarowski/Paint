import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;

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
    private HashMap<String, FigureBuilder> figureBuildersMap = new HashMap<String, FigureBuilder>()
    {{
        put("circle", new CircleBuilder());
    }};

    public static void main(String[] args) throws Exception 
    {
        MyLogger.loggerConfig();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception 
    {
        ArrayList<Double> pointsX = new ArrayList<Double>();
        pointsX.add(300.0);
        pointsX.add(400.0);

        ArrayList<Double> pointsY = new ArrayList<Double>();
        pointsY.add(300.0);
        pointsY.add(400.0);

        HashMap<String, MyShapeBuilder> myShapeBuildersMap = new HashMap<String, MyShapeBuilder>()
        {{
            put("circle", new MyCircleBuilder());
            put("rectangle", new MyRectangleBuilder());
        }};

        MyShape circle1 = myShapeBuildersMap.get("circle").BuildMyShape(pointsX, pointsY);
        MyShape rectangle1 = myShapeBuildersMap.get("rectangle").BuildMyShape(pointsX, pointsY);

        Pane root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        root.getChildren().add(new Pane(circle1.getShape()));
        root.getChildren().add(new Pane(rectangle1.getShape()));
        rectangle1.scale(2);
        rectangle1.changeColor(Color.DARKGREEN);

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }


}
