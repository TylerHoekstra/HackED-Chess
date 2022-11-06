public class Queen extends Piece{

	protected Queen(int x, int y, boolean isBlack) {
		super(x, y, isBlack);
		// TODO Auto-generated constructor stub
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
		// "Rook Movement"
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
		
		
		//Bishop Movement
		// Right+Up
		for(int i = x; i < 8; i++) {
			if(theBoard.getPieceAtPosition(new int[]{i,y+i-x}) != colour && y+i-x >= 0 && y+i-x <= 7) {
				possibleMoves.add(String.valueOf(i) + String.valueOf(y+i-x));
			}
			else
				break;
		}
		// Left+Down
		for(int i = x; i > 0; i--) {
			if(theBoard.getPieceAtPosition(new int[]{i,y+i-x}) != colour && y+i-x >= 0 && y+i-x <= 7) {
				possibleMoves.add(String.valueOf(i) + String.valueOf(y+i-x));
			}
			else
				break;
		}
		// Left+Up
		for(int i = y; i < 8; i++) {
			if(theBoard.getPieceAtPosition(new int[]{x-i+y,i}) != colour && x-i+y >= 0 && x-i+y <= 7) {
				possibleMoves.add(String.valueOf(x-i+y) + String.valueOf(i));
			}
			else
				break;
		}
		// Right+Down
		for(int i = y; i > 0; i--) {
			if(theBoard.getPieceAtPosition(new int[]{x-i+y,i}) != colour && x-i+y >= 0 && x-i+y <= 7) {
				possibleMoves.add(String.valueOf(x-i+y) + String.valueOf(i));
			}
			else
				break;
		}		
	}

}
