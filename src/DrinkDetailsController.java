import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DrinkDetailsController {
    private Drink selected = DrinkListController.selectedDrink; //A reference to the selected item
    static DrinkList _list = new DrinkList();
    // Initializes the controller class.This method is automatically called after the FXML file has been loaded.
    @FXML private Label lblName;
    @FXML private Label lblPrice;
    @FXML private RadioButton radioSmall;
    @FXML private RadioButton radioMed;
    @FXML private RadioButton radioLar;
    @FXML private Button btnAdd;
    @FXML private Button btnCancel;
    @FXML private TextField txtQty;
    @FXML private TextArea txtNote;

    @FXML private void initialize() {
        //get the item name and its price
        lblName.setText(""+selected.getDrinkName());
        lblPrice.setText(""+selected.getDrinkSmall());

        //button handler
        btnAdd.setOnAction(e -> onAddClicked());
        btnAdd.setDisable(true);
        btnCancel.setOnAction(e -> onCancelClicked());

        //Display price of the item corresponding with its size
        //when clicking on the radio button
        radioSmall.setOnAction(e -> { 
            onRadioPressed();
            lblPrice.setText(""+selected.getDrinkSmall());
            selected.setPrice(selected.getDrinkSmall());
        });
        radioMed.setOnAction(e -> {
            onRadioPressed();
            lblPrice.setText(""+selected.getPriceMed());
            selected.setPrice(selected.getPriceMed());
        });
        radioLar.setOnAction(e -> {
            onRadioPressed();
            lblPrice.setText(""+selected.getPriceLar());
            selected.setPrice(selected.getPriceLar());
        });
    }
    //radio button is selected
    private void onRadioPressed(){
        System.out.println("Selection changed.");
        btnAdd.setDisable(false);
    }
    //Cancel button
    private void onCancelClicked(){
        try{
            Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("DrinkList.fxml"));
            Scene scene = new Scene(root);
            
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
            secondStage.show();
             //Close Bill Summary window 
            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
         } catch(IOException e) {
            e.printStackTrace();
         }
    }
    //Add button
    private void onAddClicked(){
        try{
            //get value from Quantity field
            String str = txtQty.getText();
            int quantity = Integer.parseInt(str);
            //get value from Note field
            String note = txtNote.getText();
            //check validation for Quantity field
           if(quantity < 1 || quantity > 50){
                Alert alert = new Alert(AlertType.WARNING,"Quantity is out of range. Please enter quantity from 1 to 50!");
                    alert.show();
            }else{
                // Set the extra data to pass contents of the text field to the BillConfirmation controller
                _list.setQuantity(quantity);
                _list.setNote(note);
                try{
                    Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("BillConfirmation.fxml"));
                    Scene scene = new Scene(root);
                    
                    Stage secondStage = new Stage();
                    secondStage.setScene(scene);
                    secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
                    secondStage.show();
                    //Close DrinksDetails window when BillConfirmation window opens
                    Stage stage = (Stage) btnAdd.getScene().getWindow();
                    stage.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }catch(NumberFormatException e){
            Alert alert = new Alert(AlertType.WARNING,"Invalid number entered, please enter an integer again!");
            alert.show();
        }
        }
    }