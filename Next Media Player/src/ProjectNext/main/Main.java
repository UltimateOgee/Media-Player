//Shubhankar Singh 2017
package ProjectNext.main;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        final String appName = "Next Media Player";
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(
                    "/ProjectNext/view/main.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setTitle(appName);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
