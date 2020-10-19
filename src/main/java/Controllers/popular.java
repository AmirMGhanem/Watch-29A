package Controllers;

import Util.retrofitter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


public class popular implements Initializable {
    @FXML
    private ListView<String> listview;
    @FXML
    private Button btnShow;
    @FXML
    private WebView webview;
    @FXML
    private Label header;
    @FXML private ChoiceBox<Integer> ChoicePages;
    @FXML
    private Label overview;
    @FXML
    private ImageView img;
    ArrayList<String> moviesIDS = new ArrayList<String>();

    @FXML
    void onClickbtnShow(ActionEvent event) throws InterruptedException {
        String selectedID = listview.getSelectionModel().getSelectedItems().toString();
        selectedID = selectedID.substring(1, selectedID.length() - 1);
        System.out.println("Find Movie By ID - >" + Integer.parseInt(selectedID));
        retrofitter.FindMovieByID(Integer.parseInt(selectedID));
        TimeUnit.SECONDS.sleep(1);
        System.out.println(selectedID + "-------->" + retrofitter.getYoutubeKey());


        WebEngine webEngine = webview.getEngine();
        webEngine.load("https://www.youtube.com/embed/" + retrofitter.getYoutubeKey() + "?autoplay=1");
        header.setText(retrofitter.getHeader());
        overview.setText(retrofitter.getOverview());
        Image image = new Image("https://image.tmdb.org/t/p/w500/" + retrofitter.getImagepath());
        img.setImage(image);
    }

    @FXML
    public void onSelect(ActionEvent event) throws InterruptedException {
        retrofitter.setPAGES(ChoicePages.getSelectionModel().getSelectedItem());
        retrofitter.FindMovieByCategory("popular");
        TimeUnit.SECONDS.sleep(1);
        moviesIDS.clear();
        moviesIDS.addAll(retrofitter.getMoviesids());
        listview.getItems().setAll(moviesIDS);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            for(int i=1;i<500;i++)
                ChoicePages.getItems().add(i);


            retrofitter.FindMovieByCategory("popular");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            moviesIDS.addAll(retrofitter.getMoviesids());
            listview.getItems().setAll(moviesIDS);





    }


}
