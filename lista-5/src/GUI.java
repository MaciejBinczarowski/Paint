import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI 
{
    GUI(Stage stage) throws IOException 
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Pane root = fxmlLoader.load();

        Controller appController = fxmlLoader.getController();
        appController.setProperties();

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }   
}
