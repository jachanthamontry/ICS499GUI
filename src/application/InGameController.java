package application;

import java.net.URL;
import java.util.ResourceBundle;

import chess.Pawn;
import javafx.scene.control.MenuBar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InGameController implements Initializable{
	@FXML
	MenuBar myMenuBar;
	
	@FXML
	String image;
	
	
	// Event Listener on Button.onAction
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

	public String setPawn() {
		Pawn pawn = new Pawn("1", false, 1, 1);
		image = pawn.getImageURL();
		return image;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
