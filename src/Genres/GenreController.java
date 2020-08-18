package Genres;

import AddMovie.Movie;
import Application.Customer;
import Application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GenreController implements Initializable {

    @FXML private Label balance;
    @FXML private Label username;
    @FXML private Label genre;

    /**
     * Setting header values
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setText(Main.CurrentCustomer.getUsername());
        balance.setText(Main.CurrentCustomer.getCredit() +" MVR");
        genre.setText(Main.CurrentGenre);
    }

    /**
     * Mouseclick events to set the current movie
     * @param event
     * @throws IOException
     */
    @FXML
    void movie1(MouseEvent event) throws IOException {
            switchMovie(event,"The Secret World of Arrietty");
    }

    @FXML
    void movie2(MouseEvent event) throws IOException {
        switchMovie(event,"Spirited Away");
    }

    @FXML
    void movie3(MouseEvent event) throws IOException {
        switchMovie(event,"The Cat Returns");
    }

    @FXML
    void movie4(MouseEvent event) throws IOException {
        switchMovie(event,"When Marnie Was There");
    }

    @FXML
    void movie5(MouseEvent event) throws IOException {
        switchMovie(event,"Porco Rosso");
    }

    @FXML
    void movie6(MouseEvent event) throws IOException {
        switchMovie(event,"Ponyo");
    }

    @FXML
    void movie7(MouseEvent event) throws IOException {
        switchMovie(event,"Only Yesterday");
    }

    @FXML
    void movie8(MouseEvent event) throws IOException {
        switchMovie(event,"My Neighbour Totoro");
    }

    @FXML
    void movie9(MouseEvent event) throws IOException {
        switchMovie(event,"Howl's Moving Castle");
    }

    @FXML
    void movie10(MouseEvent event) throws IOException {
        switchMovie(event,"Castle In The Sky");
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
     * Scene changer to go back to dashboard
     * @param event button push
     * @throws IOException
     */
    @FXML
    void back(ActionEvent event) throws IOException {
        sceneChange(event,"CustomerDashboard/CustomerDashboard.fxml");
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

    /**
     * Scene changer that also sets the current movie as per the title provided
     * @param event button push
     * @param title movie title to be set as current movie
     * @throws IOException
     */
    public void switchMovie(MouseEvent event, String title) throws IOException {
        for (Movie movie : Movie.readingMovieDB()) {

            if (movie.getTitle().equals(title)) {
                Main.CurrentMovie = movie;
            }
        }
        Parent view2 = FXMLLoader.load(getClass().getClassLoader().getResource("BuyMovie/BuyMovie.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

}
