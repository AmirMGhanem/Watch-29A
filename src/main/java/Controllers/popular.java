package Controllers;


import Util.retrofitter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private Button btnShow;
    @FXML
    private WebView webview;

    ArrayList<String> moviesIDS = new ArrayList<String>();

    @FXML
    void onClickbtnShow(ActionEvent event) {
        String selectedID = listview.getSelectionModel().getSelectedItems().toString();
        selectedID=selectedID.substring(1,selectedID.length()-1);
        retrofitter.FindMovieByID(Integer.parseInt(selectedID));


        WebEngine webEngine= webview.getEngine();
        webEngine.load("https://www.youtube.com/embed/"+retrofitter.getYoutubeKey()+"?autoplay=1");
        System.out.println("https://www.youtube.com/embed/"+retrofitter.getYoutubeKey()+"?autoplay=1");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        moviesIDS.addAll(retrofitter.getMoviesids());
        System.out.println("on popular pane");
        System.out.println(moviesIDS);
        for (String mID : moviesIDS)
            listview.getItems().add(mID);



        //TODO
        // - static bullshit bug
        // - add header and description
        // - add full movie view link.



    }


}
