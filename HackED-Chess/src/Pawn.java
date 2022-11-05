import java.util.HashMap;

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
	public void findPossibleMoves(HashMap<int[],Piece> allPieces) {
		possibleMoves.clear();
		if(!hasMoved) {
			this.position[1] = ;
		}
		
	}

}
