import javafx.application.Application;
import javafx.stage.Stage;


/*
 * to do:
 * add saving into any file ✔
 * add visual points ✔
 * add deleting shape option ✔
 * add any polygon option 
 * add pen ?
 * add clear button
 */
public class App extends Application
{
    public static void main(String[] args) throws Exception 
    {
        MyLogger.loggerConfig();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception 
    {
        GUI gui = new GUI(stage);
    }
}
