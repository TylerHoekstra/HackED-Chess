public class Pawn extends Piece{

	private boolean hasMoved = false;
	
	protected Pawn(int x, int y, boolean isBlack) {
		super(x, y, isBlack);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void findPossibleMoves(Board theBoard) {
		int x = this.getPosition()[0];
		int y = this.getPosition()[1];
		possibleMoves.clear();
		
		// For Black
		if(isBlack) {
			// Checks moving Forward
			if(theBoard.getPieceAtPosition(new int[]{x,y-1}) == 0) {
				if(!hasMoved && theBoard.getPieceAtPosition(new int[]{x,y-2}) == 0) {
					possibleMoves.add(String.valueOf(x) + String.valueOf(y-2));
				}
				possibleMoves.add(String.valueOf(x) + String.valueOf(y-1));
			}
			
			// Checks Attack
			if(theBoard.getPieceAtPosition(new int[]{x-1,y-1}) == -1) {
				possibleMoves.add(String.valueOf(x-1) + String.valueOf(y-1));
			}
			if(theBoard.getPieceAtPosition(new int[]{x+1,y-1}) == -1) {
				possibleMoves.add(String.valueOf(x+1) + String.valueOf(y-1));
			}
		}
		// For white
		else {
			// Checks Moving Forward
			if(theBoard.getPieceAtPosition(new int[]{x,y+1}) == 0) {
				if(!hasMoved && theBoard.getPieceAtPosition(new int[]{x,y+2}) == 0) {
					possibleMoves.add(String.valueOf(x) + String.valueOf(y+2));
				}
				possibleMoves.add(String.valueOf(x) + String.valueOf(y+1));	
			}
			
			// Checks Attack
			if(theBoard.getPieceAtPosition(new int[]{x-1,y+1}) == 1) {
				possibleMoves.add(String.valueOf(x-1) + String.valueOf(y+1));
			}
			if(theBoard.getPieceAtPosition(new int[]{x+1,y+1}) == 1) {
				possibleMoves.add(String.valueOf(x+1) + String.valueOf(y+1));
			}
		}
	}
}
