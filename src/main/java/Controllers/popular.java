package Controllers;


import Util.retrofitter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class popular implements Initializable {

    @FXML
    private ListView<String> listview;

    @FXML
    private WebView webview;

    ArrayList<String> moviesIDS = new ArrayList<String>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        retrofitter rf = new retrofitter();
        moviesIDS.addAll(retrofitter.getMoviesids());
        System.out.println(moviesIDS);
        for (String mID : moviesIDS)
            listview.getItems().add(mID);

        WebEngine webEngine=webview.getEngine();
        webEngine.load(asdasd12);
        //TODO
        // - load the MovieResult arraylist and get trailer's key of it.
        // - load the webview with the choosen id.
        // - create Fxml Views for coming up and top rated.
        

    }
}
