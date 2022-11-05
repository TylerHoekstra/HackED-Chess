public class King extends Piece{

	protected King(int x, int y, boolean isBlack) {
		super(x, y, isBlack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findPossibleMoves(Board theBoard) {
		int x = this.getPosition()[0];
		int y = this.getPosition()[1];
		possibleMoves.clear();
		if (x <= 6 && y <= 6) {
			int[] spot = {x + 1, y + 1};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x <= 6) {
			int[] spot = {x + 1, y};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x <= 6 && y >= 1) {
			int[] spot = {x + 1, y - 1};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (y >= 1) {
			int[] spot = {x, y - 1};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x >= 1 && y >= 1) {
			int[] spot = {x - 1, y - 1};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x >= 1) {
			int[] spot = {x - 1, y};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (x >= 1 && y <= 6) {
			int[] spot = {x - 1, y + 1};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
		if (y <= 6) {
			int[] spot = {x, y + 1};
			if ((getIsBlack() && (theBoard.getPieceAtPosition(spot) <= 0)) || (!getIsBlack() && (theBoard.getPieceAtPosition(spot) >= 0))) {
				possibleMoves.add(String.valueOf(spot[0]) + String.valueOf(spot[1]));
			}
		}
	}

}
