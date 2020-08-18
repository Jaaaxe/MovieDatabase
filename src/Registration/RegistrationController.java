package Registration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class RegistrationController {

    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private PasswordField cn;
    @FXML private PasswordField e;
    @FXML private PasswordField csv;
    @FXML private Label message;

    /**
     * Starts a subscription for a user with 50MVR
     * @throws IOException
     */
    @FXML
    void subscribe() throws IOException {

        // Validation checks
        if(username.getText().isEmpty()||
           password.getText().isEmpty()){

            message.setText("Please enter a username and password");

        } else if (cn.getText().isEmpty()||
                e.getText().isEmpty()||
                csv.getText().isEmpty()){

            message.setText("Please enter your card details");

        } else {

            // Writes the new user into the database
            FileWriter writer = new FileWriter(System.getProperty("user.dir") + "/src/Application/Customers.txt", true);

            writer.write(username.getText() + ","
                    + password.getText() + ","
                    + "50\n");
            writer.close();

            // Clear fields
            username.setText("");
            password.setText("");
            cn.setText("");
            e.setText("");
            csv.setText("");
            message.setText("Subscribed Successfully! Please press back and login");
        }

    }

    /**
     * Scene changer to go back to login
     * @param event button push
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

}
