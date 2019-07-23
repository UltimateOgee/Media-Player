//Shubhankar Singh 2017
package ProjectNext.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;

public class ControlPaneController /*implements Initializable*/{

    @FXML
    private ProgressIndicator progressInd;

    @FXML
    private Button nextButton;

    @FXML
    private Slider volumeSlider;

    @FXML
    private Button prevButton;

    @FXML
    private ToggleButton playButton;

    public Button getPrevButton() {
        return prevButton;
    }

    public Button getNextButton() {
        return nextButton;
    }

    public ToggleButton getPlayButton() {
        return playButton;
    }

    public Slider getVolumeSlider() {
        return volumeSlider;
    }

    public ProgressIndicator getProgInd() {
        return progressInd;
    }

    /*
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    */
}