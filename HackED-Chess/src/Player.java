import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

public class Player {

	ArrayList<Piece> pieces;
	ArrayList<String> allPossibleMoves;
	boolean isBlack;
	
	//
	public Player(Board theBoard, boolean isBlack) {
		this.isBlack = isBlack;
		Set<int[]> taken = theBoard.getAllPieces().keySet();
		for (int[] pair : taken) {
			if (theBoard.getAllPieces().get(pair).getIsBlack()) {
				pieces.add(theBoard.getAllPieces().get(pair));
			}
		}
		checkMoves();
	}
	
	public boolean hasMoves() {
		return !allPossibleMoves.isEmpty();
	}
	
	public void checkMoves() {
		for (Piece piece : pieces) {
			for (String possibleMove : piece.getPossibleMoves()) {
				allPossibleMoves.add(possibleMove);
			}
		}
	}
	
	public void move(int[] currentPos, int[] newPos) {
		Iterator<Piece> itr =  pieces.iterator();
		
		while(itr.hasNext()) {
			int[] point = itr.next().getPosition();
			if(point[0] == currentPos[0] && point[1] == currentPos[1]) {
				
			}
		}
		
		
	}
	
}
