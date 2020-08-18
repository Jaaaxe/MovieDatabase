package Application;

import AddMovie.Movie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // Setting up static values so I can manipulate objects throughout the system
    public static Customer CurrentCustomer;
    public static Movie CurrentMovie;
    public static String CurrentGenre;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setScene(new Scene(root, 430, 650));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
