package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class ChessGameController implements Initializable {

	private boolean firstClick = false;
	private ImageView firstClickSpot;

	private boolean secondClick = false;
	private Node secondClickSpot;

	@FXML
	ImageView pawn_black1, pawn_black2, pawn_black3, pawn_black4, pawn_black5, pawn_black6, pawn_black7, pawn_black8,
			rook_black1, rook_black2, knight_black1, knight_black2, bishop_black1, bishop_black2, queen_black,
			king_black;

	@FXML
	ImageView pawn_white1, pawn_white2, pawn_white3, pawn_white4, pawn_white5, pawn_white6, pawn_white7, pawn_white8,
			rook_white1, rook_white2, knight_white1, knight_white2, bishop_white1, bishop_white2, queen_white,
			king_white;

	@FXML
	Rectangle a8, b8, c8, d8, e8, f8, g8, h8, a7, b7, c7, d7, e7, f7, g7, h7;

	@FXML
	Label playerTurnLabel;

	@FXML
	StackPane stackPane;

	@FXML
	GridPane gridPane;

	@FXML
	public void returnToMainMenu(ActionEvent event) {
		/*
		 * try { Parent MainMenuViewParent =
		 * FXMLLoader.load(getClass().getResource("/application/MainMenu.fxml"));
		 * //retrieves the location of the fxml file Scene menuScene = new
		 * Scene(MainMenuViewParent); //initialize the new scene as the fxml we loaded
		 * //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		 * //this line gets to the stage information Stage window = (Stage)
		 * myMenuBar.getScene().getWindow(); //currently bugs out here
		 * window.setScene(menuScene); //changes the stage scene to be our new scene
		 * window.show(); }catch(Exception e) { e.printStackTrace();
		 * System.out.println("Can't return to Main Menu"); }
		 */
		System.out.println("it doesnt work yet");
	}

//OLEGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG
	@SuppressWarnings("static-access")
	public void makeMove(MouseEvent event) {
		try {
			if (!firstClick) {
				firstClick = true;
				firstClickSpot = (ImageView) event.getSource();

				System.out.println("First Move");

			} else if (firstClick && !secondClick) {
				System.out.println("Second Move");
				secondClickSpot = (Node) event.getSource();
				gridPane.setColumnIndex(firstClickSpot, gridPane.getColumnIndex(secondClickSpot));
				gridPane.setRowIndex(firstClickSpot, gridPane.getRowIndex(secondClickSpot));
				firstClick = false;
			}
		} catch (Exception e) {
			firstClick = false;
		}

	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

	}

}
