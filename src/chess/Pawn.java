package chess;

import java.util.ArrayList;

public class Pawn extends Piece {
	// int pawnID; //ID of the pawn
	boolean firstMove = true; // If it is the pawn's first move allowing a double jump
	boolean canAttack; // If the pawn can attack
	boolean blocked; // currently blocked in front?
	char column; // Pawn's "home" column
	int col, row;
	String imageURL;

	public Pawn(String pawnID, boolean team, int row, int col) {
		this.row = row;
		this.col = col;
		this.setName("Pawn");
		this.pieceID = pawnID;
		this.setIsWhite(team);
		if (team) {
			setAbbreviation('P');
			imageURL = "@../../Images/Pawn_White.png";
		}
		else if (!team) {
			setAbbreviation('p');
			imageURL = "@../../Images/Pawn_Black.png";
		}

		this.points = 1;
	}

	@Override
	public ArrayList<BoardButton> getMoves(Piece piece, BoardButton[][] board) {
		Pawn p = (Pawn) piece;
		ArrayList<BoardButton> result = new ArrayList<BoardButton>();

		String location = p.getLocation();

		ArrayList<Integer> cords = BoardButton.toArray(location);
		int x = cords.get(0);
		int y = cords.get(1);
		boolean team = p.isWhite();

		BoardButton highSide;
		BoardButton lowSide;
		BoardButton front;

		System.out.println("\nLocation Entrered: " + location + "\n");

		System.out.println("Moves Found:");
		if (team) { // White pawn, goes up
			if (x + 1 < 8) {
				highSide = board[x + 1][y + 1];
				System.out.println("HighSide set to: " + (x + 1) + " " + (y + 1));
			} else {
				highSide = null;
				System.out.println("Highside set to: null ");
			}
			if (x - 1 > -1) {
				lowSide = board[x - 1][y + 1];
				System.out.println("LowSide set to: " + (x - 1) + " " + (y + 1));
			} else {
				lowSide = null;
				System.out.println("Lowside set to: null ");
			}
			if (y + 1 < 9) {
				front = board[x][y + 1];
				System.out.println("Front set to: " + x + " " + (y + 1));
			} else {
				front = null;
				System.out.println("Front set to: null");
			}
			if (p.firstMove()) {
				BoardButton front2 = board[x][y + 2];
				if (!front2.isFull()) {
					System.out.println("Pawn's first move! Should add " + front2.getAbbreviation() + " to list!");

					result.add(front2);
				}
			}

			if (((highSide != null) && (((highSide.getPiece() == null)) || (!highSide.getPiece().isWhite()))))
				result.add(highSide);
			if (((lowSide != null) && (((lowSide.getPiece() == null)) || (!lowSide.getPiece().isWhite()))))
				result.add(lowSide);
			if (!front.isFull() && y != 7)
				result.add(front);

		} else { // Black team, pawn down
			if (x + 1 < 8) {
				highSide = board[x + 1][y - 1];
				System.out.println("HighSide set to: " + (x + 1) + " " + (y - 1));
			} else {
				highSide = null;
				System.out.println("Highside set to null ");
			}
			if (x - 1 > -1) {
				lowSide = board[x - 1][y - 1];
				System.out.println("LowSide set to: " + (x - 1) + " " + (y - 1));
			} else {
				lowSide = null;
				System.out.println("Lowside set to null ");
			}
			if (y - 1 > -1) {
				front = board[x][y - 1];
				System.out.println("Front set to: " + x + " " + (y - 1));
			} else {
				front = null;
				System.out.println("Front set to null");
			}
			if (p.firstMove()) {
				BoardButton front2 = board[x][y - 2];
				if (!front2.isFull()) {
					result.add(front2);
				}
			}

			if (highSide != null && highSide.isFull() && highSide.getPiece().isWhite())
				result.add(highSide);
			if (lowSide != null && lowSide.isFull() && lowSide.getPiece().isWhite())
				result.add(lowSide);
			if (!front.isFull() && y != 7)
				result.add(front);
		}
		return result;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public boolean firstMove() {
		return this.firstMove;
	}

	public void madeFirstMove() {
		this.firstMove = true;
	}

	public String getImageURL() {
		return imageURL;
	}
}