//Shubhankar Singh 2017
package ProjectNext.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuPaneController implements Initializable {

	@FXML
	private MenuItem aboutMenuItem;

	@FXML
	private MenuItem fileMenuItem;

	@FXML
	private MenuItem dirMenuItem;

	@FXML
	private Menu fileMenu;

	public MenuItem getFileMenuItem() {
		return fileMenuItem;
	}

	public MenuItem getDirMenuItem() {
		return dirMenuItem;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		configureMenu();
	}

	private void configureMenu() {
		aboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Parent parent = null;
				try {
					parent = FXMLLoader.load(getClass().getResource("/ProjectNext/view/about.fxml"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene scene = new Scene(parent);
				Stage stage = new Stage();
				stage.setTitle("About");
				stage.setScene(scene);
				stage.show();
			}
		});
	}
}