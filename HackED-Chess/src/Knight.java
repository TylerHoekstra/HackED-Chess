public class Knight extends Piece{

	protected Knight(int x, int y, boolean isBlack) {
		super(x, y, isBlack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void findPossibleMoves(Board theBoard) {
		int x = this.getPosition()[0];
		int y = this.getPosition()[1];
		possibleMoves.clear();
		if (x <= 6 && y <= 5) {
			int[] spot = {x + 1, y + 2};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x <= 5 && y <= 6) {
			int[] spot = {x + 2, y + 1};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x <= 5 && y >= 1) {
			int[] spot = {x + 2, y - 1};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x <= 6 && y >= 2) {
			int[] spot = {x + 1, y - 2};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x >= 1 && y >= 2) {
			int[] spot = {x - 1, y - 2};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x >= 2 && y >= 1) {
			int[] spot = {x - 2, y - 1};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x >= 2 && y <= 6) {
			int[] spot = {x -2 , y + 1};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x >= 1 && y <= 5) {
			int[] spot = {x - 1, y + 2};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
	}

}
