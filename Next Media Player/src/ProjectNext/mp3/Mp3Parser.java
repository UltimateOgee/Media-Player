package ProjectNext.mp3;

import java.io.File;
import java.io.IOException;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Mp3Parser {
    public Mp3Song createMp3Song(File file) {
        Mp3Song result = new Mp3Song();
        Mp3File mp3File = null;
        try {
            mp3File = new Mp3File(file);
        } catch (InvalidDataException | UnsupportedTagException | IOException e) {
            e.printStackTrace();
        }
        result.setFilePath(file.getAbsolutePath());
        result.setTitle(mp3File.getId3v2Tag().getTitle());
        result.setAuthor(mp3File.getId3v2Tag().getAlbumArtist());
        result.setAlbum(mp3File.getId3v2Tag().getAlbum());

        return result;
    }

    public ObservableList<Mp3Song> createMp3Songs(File dir) {
        if (!dir.isDirectory()) {
            return null;
        }

        ObservableList<Mp3Song> result = FXCollections.observableArrayList();
        File[] files = dir.listFiles();
        for (File f : files) {
            String fileExtension = f.getName().substring(f.getName().lastIndexOf(".") + 1);
            if (fileExtension.equals("mp3"))
                result.add(createMp3Song(f));
        }

        return result;
    }
}