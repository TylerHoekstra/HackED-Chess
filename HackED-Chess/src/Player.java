import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;

public class Player {

	ArrayList<Piece> pieces = new ArrayList<Piece>();
	ArrayList<String> allPossibleMoves = new ArrayList<String>();
	boolean isBlack;
	
	//
	public Player(Board theBoard, boolean isBlack) {
		this.isBlack = isBlack;
		Set<int[]> taken = theBoard.getAllPieces().keySet();
		for (int[] pair : taken) {
			if (theBoard.getAllPieces().get(pair).getIsBlack() == isBlack) {
				pieces.add(theBoard.getAllPieces().get(pair));
			}
		}
		checkMoves();
	}
	
	public void remPiece(Piece removePiece) {
		pieces.remove(removePiece);
		checkMoves();
	}
	
	public boolean hasMoves() {
		return !allPossibleMoves.isEmpty();
	}
	
	public Piece getPiece(int[] space) {
		Iterator<Piece> itr =  pieces.iterator();
		Piece selPiece;
		while(itr.hasNext()) {
			selPiece = itr.next();
			int[] point = selPiece.getPosition();
			if(point[0] == space[0] && point[1] == space[1]) {
				return selPiece;
			}
		}
		return null;
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
		String strNewPos = String.valueOf(newPos[0]) + String.valueOf(newPos[1]);
		Piece selPiece;
		while(itr.hasNext()) {
			selPiece = itr.next();
			int[] point = selPiece.getPosition();
			if(point[0] != currentPos[0] || point[1] != currentPos[1]) {
				selPiece = null;
			}
			if(selPiece != null) {
				ArrayList<String> moves = selPiece.getPossibleMoves();
				Iterator<String> stir =  moves.iterator();
				while(stir.hasNext()) {
					String newPoint = stir.next();
					if(newPoint.equals(strNewPos))
						selPiece.move(newPos);
					break;
				}
				break;
			}
		}
	}
	
}
