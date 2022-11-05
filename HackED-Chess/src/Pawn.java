public class Pawn extends Piece{

	private boolean hasMoved = false;
	
	protected Pawn(int x, int y, boolean isBlack) {
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
		if(isBlack) {
			if(!hasMoved && theBoard.getPieceAtPosition == 0) {
				possibleMoves.add(String.valueOf(x) + String.valueOf(y-2));
			}
			possibleMoves.add(String.valueOf(x) + String.valueOf(y-1));
		}
		else {
			if(!hasMoved) {
				possibleMoves.add(String.valueOf(x) + String.valueOf(y+2));;
			}
			possibleMoves.add(String.valueOf(x) + String.valueOf(y+1));
		}
	}

}
