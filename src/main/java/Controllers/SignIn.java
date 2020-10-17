package Controllers;

import Util.FxmlLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignIn implements Initializable {

    @FXML
    private Button ForgetPassword;

    @FXML
    private Button Login;
    FxmlLoader fxmlLoader = new FxmlLoader();
    @FXML
    void OnClickForgetPassword(ActionEvent event) {

    }

    @FXML
    void OnLogin(ActionEvent event) throws IOException {
        System.out.println("Medicine Clicked");
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("Main");
        Stage stage = new Stage();
        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.show();



    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
