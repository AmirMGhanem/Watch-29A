package Controllers;

import Util.FxmlLoader;
import Util.retrofitter;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Main implements Initializable {
    @FXML
    private AnchorPane Parent;
    @FXML
    private BorderPane BorderLayoutPane;

    @FXML
    private Pane pane;

    @FXML
    private HBox Btnpopular;

    @FXML
    private HBox BtnTopRated;

    @FXML
    private HBox UpComing;

    @FXML
    void onClickBtnTopRated(MouseEvent event) {

    }

    @FXML
    void onClickBtnpopular(MouseEvent event) throws IOException {

        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("popularPane");
        BorderLayoutPane.setCenter(view);
    }

    @FXML
    void onClickUpComing(MouseEvent event) {

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        retrofitter rf = new retrofitter();

//        WebView webView = new WebView();
//        WebEngine webEngine = webView.getEngine();
//        webEngine.load("https://www.youtube.com/embed/1roy4o4tqQM?autoplay=1");
//        webView.setPrefSize(640,340);
//        webView.setLayoutY(pane00.getLayoutY());
//        webView.setLayoutX(pane00.getLayoutX());
//        pane00.getChildren().add(webView);


    }

}
