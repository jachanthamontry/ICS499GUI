package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import gradleproject1.Board;
import gradleproject1.BoardButton;
import gradleproject1.GameState;
import gradleproject1.Move;
import gradleproject1.Piece;
import gradleproject1.Player;
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
	private BoardButton[][] GameBoard;
	private GameState g;
	private static Board b;
	private ArrayList<BoardButton> moves;
	private Piece test = null;

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

	@SuppressWarnings("static-access")
	public void makeMove(MouseEvent event) {
		System.out.println("Click");
		int x, y, x2, y2;

		try {
			if (!firstClick) {
				moves = null;
				test = null;
				BoardButton a = null;
				firstClick = true;
				firstClickSpot = (ImageView) event.getSource();
				y = gridPane.getColumnIndex(firstClickSpot);
				x = gridPane.getRowIndex(firstClickSpot);
				a = GameBoard[x][y];
				System.out.println(x + " " + y + "Entered");
				test = a.getPiece();
				if (test.isWhite() != g.whoseTurn()) {

					firstClick = false;
				}

				moves = test.getMoves(test, GameBoard); // Make sure the moves list isnt' null, would previously 'pass'
														// your turn
				for (int ctr = 0; ctr < moves.size(); ctr++)
					System.out.print(moves.get(ctr).getAbbreviation() + ", ");

				if (moves.size() == 0) {
					firstClick = false;

				}

				System.out.println("First Move" + firstClick);

			} else if (firstClick && !secondClick) {
				Move moveIteration = null;

				System.out.println("Second Move");

				secondClickSpot = (Node) event.getSource();

				y2 = gridPane.getColumnIndex(secondClickSpot);
				x2 = gridPane.getRowIndex(secondClickSpot);

				System.out.println(x2 + " " + (y2 + 1) + "Entered");
				for (BoardButton butn : moves) {
					System.out.println(+butn.getRow() + " " + butn.getColumn());
					if (butn.getRow() == x2 && butn.getColumn() == y2 + 1) {
						System.out.println("Succes");
						Piece enemy = butn.getPiece();
						moveIteration = new Move(test, butn);
						gridPane.setColumnIndex(firstClickSpot, gridPane.getColumnIndex(secondClickSpot));
						gridPane.setRowIndex(firstClickSpot, gridPane.getRowIndex(secondClickSpot));
						firstClick = false;
						g.turn();

						if (moveIteration.getAbbreviation().contains("x")) {
							System.out.println("Piece captured!");
							if (enemy.isWhite())
								System.out.println("White " + enemy.getName() + " captured on square "
										+ butn.getAbbreviation() + "!");
							else
								System.out.println("Black " + enemy.getName() + " captured on square "
										+ butn.getAbbreviation() + "!");
						}

					} else {
						firstClick = false;
					}

				}

			}
			b.draw(b);

		} catch (Exception e) {
			firstClick = false;
			System.out.println("Fail");

		}

		if (g.whoseTurn())
			playerTurnLabel.setText("White Turn");
		else
			playerTurnLabel.setText("Black Turn");

	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		g = new GameState();

		try {
			b = initDefault();
		} catch (Exception e) {

			e.printStackTrace();
		}
		GameBoard = b.getGameBoard();

		g.setWhite(b.getWhitePlayer());
		g.setBlack(b.getBlackPlayer());
		Move.setGameBoard(b);

	}

	public static Board initDefault() throws Exception {

		Player whitePlayer = new Player(true, false, 3);
		Player blackPlayer = new Player(false, false, 3);
		Move.setWhitePlayer(whitePlayer);
		Move.setBlackPlayer(blackPlayer);

		b = new Board(whitePlayer, blackPlayer);

		b.initBoard();
		return b;
	}

}
