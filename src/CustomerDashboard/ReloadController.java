package CustomerDashboard;

import Application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class ReloadController {

    @FXML private PasswordField cn;
    @FXML private PasswordField e;
    @FXML private PasswordField csv;
    @FXML private Label message;
    @FXML private RadioButton ten;
    @FXML private RadioButton thirty;
    @FXML private RadioButton fifty;
    @FXML private RadioButton hundred;


    /**
     * Adds selected value of money to the current customer
     * @throws IOException
     */
    @FXML
    void reload() {

        if(selectorCheck()) {

            if(fieldCheck()){

                message.setText("");

                // Adds the money to the credit of the customer object
                if (ten.isSelected()) {
                    Main.CurrentCustomer.setCredit(Main.CurrentCustomer.getCredit() + 10);
                } else if (thirty.isSelected()) {
                    Main.CurrentCustomer.setCredit(Main.CurrentCustomer.getCredit() + 30);
                } else if (fifty.isSelected()) {
                    Main.CurrentCustomer.setCredit(Main.CurrentCustomer.getCredit() + 50);
                } else if (hundred.isSelected()) {
                    Main.CurrentCustomer.setCredit(Main.CurrentCustomer.getCredit() + 100);
                }

                // Clears values
                cn.setText("");
                e.setText("");
                csv.setText("");
                message.setText("Successfully Reloaded");


            } else {
                message.setText("Please enter your card details");
            }

        } else {
            message.setText("Please select a value");
        }


    }

    /**
     * Validation check to see if money amount is selected
     * @return true if correctly selected
     */
    public boolean selectorCheck(){

        boolean valid = true;

        if(!ten.isSelected()&&
        !thirty.isSelected()&&
        !fifty.isSelected()&&
        !hundred.isSelected()){
            valid = false;
        }

        return valid;
    }

    /**
     * Validation check to see if fields are filled
     * @return true if correctly filled
     */
    public boolean fieldCheck(){
        boolean valid = true;

       if (cn.getText().isEmpty()||
               e.getText().isEmpty()||
               csv.getText().isEmpty()){
           valid = false;
       }
        return valid;
    }

    /**
     * Scene changer to go back to dashboard
     * @param event button push
     * @throws IOException
     */
    @FXML
    void back(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getClassLoader().getResource("CustomerDashboard/CustomerDashboard.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }


}
