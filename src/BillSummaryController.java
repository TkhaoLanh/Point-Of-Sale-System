import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class BillSummaryController {
    private Drink selected = DrinkListController.selectedDrink;//A reference to the selected item
    private DrinkList _list = DrinkDetailsController._list;// A reference to the list of items

    // Field variables for GUI controls should go here
    @FXML private Label lblProduct;
    @FXML private Label lblPrice;
    @FXML private Label lblQty;
    @FXML private Label lblSubTotal;
    @FXML private Label lblTax;
    @FXML private Label lblTotal;
    @FXML private Label lblOrder;
    @FXML private Button btnPrint;
    @FXML private Button btnBack;
    @FXML private TextField txtDate;
    @FXML private ImageView imageView;
    // Initializes the controller class.This method is automatically called after the FXML file has been loaded.
    @FXML private void initialize() {
        //get value of item and its price, quantity
        lblProduct.setText(""+selected.getDrinkName());
        lblPrice.setText(""+selected.getPrice());
        lblQty.setText(""+_list.getQuantity());

        //Calculate subtotal, tax and total
        double subtotal = selected.getPrice() * _list.getQuantity();
        lblSubTotal.setText(String.format("%.1f",(subtotal)));
        lblTax.setText(String.format("%.1f",(subtotal *13/100)));
        double total = subtotal *13/100 + subtotal;
        lblTotal.setText(String.format("%.1f",(total)));

        //Display order number from 1 to 100
        int randOrd = (int)(Math.random() * 101);
        lblOrder.setText("" + randOrd);

        //Display current date and time
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        txtDate.setText(dateFormat.format(cal.getTime()));
        txtDate.setDisable(true);
        
        //button handlers for btnClose and btnPrint
        btnPrint.setOnAction( e -> onPrintClicked());
        btnBack.setOnAction( e -> onBackClicked());

        
    }

    //button Print Bill
    public void onPrintClicked(){
       
        Alert alert = new Alert(AlertType.INFORMATION," THANK YOU FOR CHOOSING US, HAVE A WONDERFUL DAY ");
        alert.show();
        Stage stage = (Stage) btnPrint.getScene().getWindow();
        stage.close();
       
    }

    public void onBackClicked(){
        try{
            Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("BillConfirmation.fxml"));
            Scene scene = new Scene(root);
            
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
            secondStage.show();
             //Close Bill Summary window 
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.close();
         } catch(IOException e) {
            e.printStackTrace();
         }
    }
}