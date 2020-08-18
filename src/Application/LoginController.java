package Application;

import AddMovie.Movie;
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

import java.io.IOException;

public class LoginController {

    @FXML public TextField username;
    @FXML private PasswordField password;
    @FXML private Label error;

    /**
     * Login function
     * @param event button press
     */
    @FXML
    void login(ActionEvent event) {

        // Null checkers
        if (username.getText().isEmpty() && password.getText().isEmpty()) {
            error.setText("Please enter your login credentials");
        } else if (username.getText().isEmpty()) {
            error.setText("Please enter your username");
        } else if (password.getText().isEmpty()) {
            error.setText("Please enter your password");
        } else {
            error.setText("");
            verifyLogin(username.getText(), password.getText(), event);
        }

    }

    /**
     * Checks to see if credentials are valid
     * @param user
     * @param pass
     * @param event
     */
    public void verifyLogin(String user, String pass, ActionEvent event) {

        try {

                for (Customer customer : Customer.readingDB()) {
                    // Goes through the customer objects and once verified the customer is set as a static current customer
                    if (customer.getUsername().equals(user) && customer.getPassword().equals(pass)) {
                        Main.CurrentCustomer = customer;

                        // Sends user to the relevant scene, Admin gets an add movie screen
                        if (customer.getUsername().equals("Admin")) {
                            sceneChange(event, "AddMovie/AddMovie.fxml");
                        } else {
                            sceneChange(event, "CustomerDashboard/CustomerDashboard.fxml");
                        }

                    } else {
                        error.setText("Your username and / or password is incorrect");
                    }
                }

        } catch (Exception e) {
            System.out.println("Error:" + e.getLocalizedMessage());
        }

    }

    /**
     * Scene change to create new customer
     * @param event button push
     * @throws IOException
     */
    @FXML
    void createNew(ActionEvent event) throws IOException {
        sceneChange(event, "Registration/Registration.fxml");
    }

    /**
     * Helps to switch between scenes easily
     * @param event relevant button push event
     * @param fxmlFile string of the relevant fxml file to change scenes to
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