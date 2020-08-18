package AddMovie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class AddMovieController {

    @FXML private TextField cast;
    @FXML private TextField producer;
    @FXML private TextField rating;
    @FXML private TextField title;
    @FXML private TextField price;
    @FXML private TextField genre;
    @FXML private TextArea review;
    @FXML private TextArea summary;
    @FXML private TextField filepath;
    @FXML private Label message;
    @FXML private Label error;

    /**
     * Adds a new movie into the DB
     * @throws IOException
     */
    @FXML
    void addMovie() throws IOException {

        if(nullChecker()){

            message.setText(""); // Clear error

            // Adds new movie item to DB
            FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/src/AddMovie/Movies.txt", true);

            writer.write(title.getText() + ","
                    + cast.getText() + ","
                    + producer.getText() + ","
                    + rating.getText() + ","
                    + genre.getText() + ","
                    + review.getText() + ","
                    + summary.getText() + ","
                    + price.getText() + ","
                    + filepath.getText() + "\n");
            writer.close();

            eraser();
            message.setText("Added Successfully!");

        } else {
            error.setText("Please fill all the fields");
        }

    }

    /**
     * Scene changer to go back
     * @param event buton click
     * @throws IOException
     */
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getClassLoader().getResource("Application/Login.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    /**
     * Validation
     * @return true if all fields are filled
     */
    public boolean nullChecker(){

        boolean valid = true;

        if(cast.getText().isEmpty()||
        producer.getText().isEmpty()||
        rating.getText().isEmpty()||
        title.getText().isEmpty()||
        price.getText().isEmpty()||
        genre.getText().isEmpty()||
        review.getText().isEmpty()||
        summary.getText().isEmpty()||
        filepath.getText().isEmpty()){
            valid = false;
        }

        return valid;
    }

    /**
     * Erases data for next entry
     */
    public void eraser(){
        cast.setText("");
        producer.setText("");
        rating.setText("");
        title.setText("");
        price.setText("");
        genre.setText("");
        review.setText("");
        summary.setText("");
        filepath.setText("");
    }

}
