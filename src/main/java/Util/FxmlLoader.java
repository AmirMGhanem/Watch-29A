package Util;


import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import view.MultipleFxmlHandling;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getPage(String fileName) throws IOException {

        try {
            URL fileUrl = MultipleFxmlHandling.class.getResource("/FxmlFiles/" + fileName + ".fxml");

            if (fileUrl == null) {
                throw new FileNotFoundException("FXML file can't be found!");
            }

            view = new FXMLLoader().load(fileUrl);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return view;
    }

}

