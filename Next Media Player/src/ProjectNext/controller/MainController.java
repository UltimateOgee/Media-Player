//Shubhankar Singh 2017
package ProjectNext.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import ProjectNext.mp3.Mp3Song;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;
import ProjectNext.mp3.Mp3Parser;
import ProjectNext.mp3.Mp3Player;

public class MainController implements Initializable {

	@FXML
	private ContentPaneController contentPaneController;
	@FXML
	private ControlPaneController controlPaneController;
	@FXML
	private MenuPaneController menuPaneController;

    private Mp3Player mp3Player;
    private Mp3Parser mp3Parser;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
        mp3Player = new Mp3Player();
        mp3Parser = new Mp3Parser();
        configControlPaneAction();
        configureVolume();
        configureTable();
        configureMenu();
    }

    private void configControlPaneAction() {
        TableView<Mp3Song> contentTable = contentPaneController.getContentTable();
        ToggleButton playButton = controlPaneController.getPlayButton();
        Button prevButton = controlPaneController.getPrevButton();
        Button nextButton = controlPaneController.getNextButton();

        playButton.setOnAction(event -> {
            if (playButton.isSelected())
                mp3Player.play();
            else mp3Player.stop();
        });

        nextButton.setOnAction(event -> {
            contentTable.getSelectionModel().select(contentTable.getSelectionModel().getSelectedIndex() + 1);
            mp3Player.loadSong(contentTable.getSelectionModel().getSelectedIndex());
        });

        prevButton.setOnAction(event -> {
            contentTable.getSelectionModel().select(contentTable.getSelectionModel().getSelectedIndex() - 1);
            mp3Player.loadSong(contentTable.getSelectionModel().getSelectedIndex());
        });
    }

    private void configureVolume() {
        //ProgressIndicator prog = controlPaneController.getProgInd();
        Slider volSlider = controlPaneController.getVolumeSlider();
        final double minVolume = 0;
        final double maxVolume = 1;
        volSlider.setMin(minVolume);
        volSlider.setMax(maxVolume);
        volSlider.setValue(maxVolume);
        volSlider.valueProperty().addListener((observable, oldValue, newValue)
                -> mp3Player.setVolume(newValue.doubleValue()));
        //prog.setProgress(volSlider.getValue());
        //System.out.println(volSlider.getValue());
    }

    private void configureTable() {
        TableView<Mp3Song> contentTable = contentPaneController.getContentTable();
        contentTable.setItems(mp3Player.getMp3Collection().getSongList());
        contentTable.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getClickCount() == 2) {
                mp3Player.loadSong(contentTable.getSelectionModel().getSelectedIndex());
                controlPaneController.getPlayButton().setSelected(true);
            }
        });
    }

    private void configureMenu() {
        MenuItem openFile = menuPaneController.getFileMenuItem();
        MenuItem openDir = menuPaneController.getDirMenuItem();

        openFile.setOnAction(event -> {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new ExtensionFilter("Mp3", "*.mp3"));
            File file = fc.showOpenDialog(new Stage());
            mp3Player.getMp3Collection().clear();
            mp3Player.getMp3Collection().addSong(mp3Parser.createMp3Song(file));
        });

        openDir.setOnAction(event -> {
            DirectoryChooser dc = new DirectoryChooser();
            File dir = dc.showDialog(new Stage());
            mp3Player.getMp3Collection().clear();
            mp3Player.getMp3Collection().addSongs(mp3Parser.createMp3Songs(dir));
        });
    }
}