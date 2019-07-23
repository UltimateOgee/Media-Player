//Shubhankar Singh 2017
package ProjectNext.controller;

import java.net.URL;
import java.util.ResourceBundle;

import ProjectNext.mp3.Mp3Song;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ContentPaneController implements Initializable {

    private static final String TITLE_COLUMN = "Title";
    private static final String AUTHOR_COLUMN = "Author";
    private static final String ALBUM_COLUMN = "Album";

    @FXML
    private TableView<Mp3Song> contentTable;

    public TableView<Mp3Song> getContentTable() {
        return contentTable;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureTable();
    }

    private void configureTable() {
        TableColumn<Mp3Song, String> titleColumn = new TableColumn<>(TITLE_COLUMN);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));

        TableColumn<Mp3Song, String> authorColumn = new TableColumn<>(AUTHOR_COLUMN);
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));

        TableColumn<Mp3Song, String> albumColumn = new TableColumn<>(ALBUM_COLUMN);
        albumColumn.setCellValueFactory(new PropertyValueFactory<>("Album"));

        getContentTable().getColumns().add(titleColumn);
        getContentTable().getColumns().add(authorColumn);
        getContentTable().getColumns().add(albumColumn);
    }

}