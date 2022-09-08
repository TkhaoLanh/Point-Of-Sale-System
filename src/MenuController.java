import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuController {
    static DrinkList _list = new DrinkList();
    public String drinkType;
    
    // Field variables for GUI controls should go here
    @FXML private Button btnHot;
    @FXML private Button btnCold;

    // Initializes the controller class. This method is automatically called after the FXML file has been loaded.
    @FXML private void initialize() {
        // Attach event handler(s)
       btnHot.setOnAction( e -> { 
            onHotClicked(); 
        });    // Always call a method in the outer class
        btnCold.setOnAction( e -> { 
            onColdClicked(); 
        });   // Always call a method in the outer class

    }
    // Click handler for OK button
    private void onHotClicked() {
        // Open the DrinkList window (stage)
        try {
            drinkType = "Hot";
            _list.load(drinkType);
            Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("DrinkList.fxml"));
            Scene scene = new Scene(root);
            
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
            secondStage.showAndWait();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private void onColdClicked() {
        // Open the DrinkList window (stage)
        try {
            drinkType = "Cold";
            _list.load(drinkType);
            Parent root = (AnchorPane)FXMLLoader.load(getClass().getResource("DrinkList.fxml"));
            Scene scene = new Scene(root);
            
            Stage secondStage = new Stage();
            secondStage.setScene(scene);
            secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
            secondStage.showAndWait();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
