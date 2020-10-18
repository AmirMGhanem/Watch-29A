package view;

import Util.retrofitter;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.fxml.FXMLLoader.load;

public class MultipleFxmlHandling extends Application {
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        MultipleFxmlHandling.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        setPrimaryStage(stage);
        Parent root = load(getClass().getResource("/FxmlFiles/SignIn.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        retrofitter rf = new retrofitter();
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);


    }
}
