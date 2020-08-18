package BuyMovie;

import Application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuyMovieController implements Initializable {

    @FXML private Label balance;
    @FXML private Label username;
    @FXML private Label title;
    @FXML private Label rating;
    @FXML private Label summary;
    @FXML private Label review;
    @FXML private Label cast;
    @FXML private Label producer;
    @FXML private Label genre;
    @FXML private Label price;
    @FXML private ImageView poster;

    /**
     * Sets the scene with relevant information
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        username.setText(Main.CurrentCustomer.getUsername());
        balance.setText(Main.CurrentCustomer.getCredit() +" MVR");
        title.setText(Main.CurrentMovie.getTitle());
        rating.setText(Main.CurrentMovie.getRating());
        summary.setText(Main.CurrentMovie.getSummary());
        review.setText(Main.CurrentMovie.getReview());
        cast.setText(Main.CurrentMovie.getCast());
        producer.setText(Main.CurrentMovie.getProducer());
        genre.setText(Main.CurrentMovie.getGenre());
        price.setText(Main.CurrentMovie.getPrice() + " MVR");
        poster.setImage(Main.CurrentMovie.getMovieURL());
    }

    /**
     * Deducts the movie price from the current user's balance
     */
    @FXML
    void buyMovie() {
        Main.CurrentCustomer.setCredit(Main.CurrentCustomer.getCredit()-Main.CurrentMovie.getPrice());
        balance.setText(Main.CurrentCustomer.getCredit() + " MVR");
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
     * Scene changer to go back to genre scene
     * @param event button push
     * @throws IOException
     */
    @FXML
    void back(ActionEvent event) throws IOException {
        sceneChange(event,"Genres/Genre.fxml");
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
