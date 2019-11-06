package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ChessGameController implements Initializable {

    @FXML
    ImageView pawn_black1;

    @FXML
    public void returnToMainMenu(ActionEvent event) {
        /*
         * try {
         * Parent MainMenuViewParent =
         * FXMLLoader.load(getClass().getResource("/application/MainMenu.fxml"));
         * //retrieves the location of the fxml file Scene menuScene = new
         * Scene(MainMenuViewParent); //initialize the new scene as the fxml we loaded
         * //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
         * //this line gets to the stage information Stage window = (Stage)
         * myMenuBar.getScene().getWindow(); //currently bugs out here
         * window.setScene(menuScene); //changes the stage scene to be our new scene
         * window.show();
         * }catch(Exception e) { e.printStackTrace();
         * System.out.println("Can't return to Main Menu"); }
         */
        System.out.println("it doesnt work yet");
    }









    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
