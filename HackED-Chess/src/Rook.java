public class Rook extends Piece{

	protected Rook(int x, int y, boolean isBlack) {
		super(x, y, isBlack);
	}

	@Override
	public void findPossibleMoves(Board theBoard) {
		int x = this.getPosition()[0];
		int y = this.getPosition()[1];
		possibleMoves.clear();
		int colour;
		if(isBlack)
			colour = 1;
		else
			colour = -1;
		// Right
		for(int i = x; i < 8; i++) {
			if(theBoard.getPieceAtPosition(new int[]{i,y}) != colour) {
				possibleMoves.add(String.valueOf(i) + String.valueOf(y));
			}
			else
				break;
		}
		// Left
		for(int i = x; i > 0; i--) {
			if(theBoard.getPieceAtPosition(new int[]{i,y}) != colour) {
				possibleMoves.add(String.valueOf(i) + String.valueOf(y));
			}
			else
				break;
		}
		// Up
		for(int i = y; i < 8; i++) {
			if(theBoard.getPieceAtPosition(new int[]{x,i}) != colour) {
				possibleMoves.add(String.valueOf(x) + String.valueOf(i));
			}
			else
				break;
		}
		// Down
		for(int i = y; i > 0; i--) {
			if(theBoard.getPieceAtPosition(new int[]{x,i}) != colour) {
				possibleMoves.add(String.valueOf(x) + String.valueOf(i));
			}
			else
				break;
		}
	}
	
}
