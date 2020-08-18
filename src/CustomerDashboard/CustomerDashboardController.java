package CustomerDashboard;

import Application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerDashboardController implements Initializable {

    @FXML private Label username;
    @FXML private Label balance;

    /**
     * Sets header with details about logged in user
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setText(Main.CurrentCustomer.getUsername());
        balance.setText(Main.CurrentCustomer.getCredit() +" MVR");
    }

    /**
     * Setting the current genre based on poster selected
     * @param event button press
     * @throws IOException
     */
    @FXML
    void action(ActionEvent event) throws IOException {
        Main.CurrentGenre = "Action";
        sceneChange(event,"Genres/Genre.fxml");
    }

    @FXML
    void animation(ActionEvent event) throws IOException {
        Main.CurrentGenre = "Animation";
        sceneChange(event,"Genres/Genre.fxml");
    }

    @FXML
    void comedy(ActionEvent event) throws IOException {
        Main.CurrentGenre = "Comedy";
        sceneChange(event,"Genres/Genre.fxml");
    }

    @FXML
    void drama(ActionEvent event) throws IOException {
        Main.CurrentGenre = "Drama";
        sceneChange(event,"Genres/Genre.fxml");
    }

    @FXML
    void fiction(ActionEvent event) throws IOException {
        Main.CurrentGenre = "Fiction";
        sceneChange(event,"Genres/Genre.fxml");
    }

    @FXML
    void horror(ActionEvent event) throws IOException {
        Main.CurrentGenre = "Horror";
        sceneChange(event,"Genres/Genre.fxml");
    }

    /**
     * Scene change to reload screen
     * @param event button push
     * @throws IOException
     */
    @FXML
    void reload(ActionEvent event) throws IOException {
        sceneChange(event,"CustomerDashboard/Reload.fxml");
    }

    /**
     * Scene changer to go back to login
     * @param event button push
     * @throws IOException
     */
    @FXML
    void back(ActionEvent event) throws IOException {
        sceneChange(event,"Application/Login.fxml");
    }

    /**
     * Scene changer function
     * @param event button press
     * @param fxmlFile source of the next scene's fxml file
     * @throws IOException
     */
    public void sceneChange(ActionEvent event, String fxmlFile) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlFile));
        Scene scene2 = new Scene(view2);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
}
