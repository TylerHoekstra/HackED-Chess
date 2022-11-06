import java.util.ArrayList;
import java.util.Set;

public class Player {

	ArrayList<Piece> pieces;
	ArrayList<String> allPossibleMoves;
	boolean isBlack;
	
	public Player(Board theBoard, boolean isBlack) {
		this.isBlack = isBlack;
		Set<int[]> taken = theBoard.getAllPieces().keySet();
		for (int[] pair : taken) {
			if (theBoard.getAllPieces().get(pair).getIsBlack()) {
				pieces.add(theBoard.getAllPieces().get(pair));
			}
		}
		for (Piece piece : pieces) {
			for (String possibleMove : piece.getPossibleMoves()) {
				allPossibleMoves.add(possibleMove);
			}
		}
	}
	
	public boolean hasMoves() {
		return !allPossibleMoves.isEmpty();
	}
	
	public void move() {
		
	}
	
}
