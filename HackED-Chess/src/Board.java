import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Board {
	
	private HashMap<int[],Piece> allPieces = new HashMap<int[], Piece>();
	
	public Board() {
		// Rooks initialization
		int[] r1 = {0,0};
		allPieces.put(r1 ,new Rook(0, 0, false));
		int[] r2 = {0,7};
		allPieces.put(r2 ,new Rook(0, 7, true));
		int[] r3 = {7,0};
		allPieces.put(r3 ,new Rook(7, 0, false));
		int[] r4 = {7,7};
		allPieces.put(r4 ,new Rook(7, 7, true));
		
		// Pawns initialization
		for(int i = 0; i<8; i++) {
			int[] p1 = {i,1};
			allPieces.put(p1 ,new Pawn(i, 1, false));
		}
		for(int i = 0; i<8; i++) {
			int[] p2 = {i,6};
			allPieces.put(p2 ,new Pawn(i, 6, true));
		}
		
		// Knight Initialization
		int[] Kn1 = {1,0};
		allPieces.put(Kn1 ,new Knight(1, 0, false));
		int[] Kn2 = {1,7};
		allPieces.put(Kn2 ,new Knight(1, 7, true));
		int[] Kn3 = {6,0};
		allPieces.put(Kn3 ,new Knight(6, 0, false));
		int[] Kn4 = {6,7};
		allPieces.put(Kn4 ,new Knight(6, 7, true));
		
		// Bishop Initialization
		int[] B1 = {2,0};
		allPieces.put(B1 ,new Bishop(2, 0, false));
		int[] B2 = {2,7};
		allPieces.put(B2 ,new Bishop(2, 7, true));
		int[] B3 = {5,0};
		allPieces.put(B3 ,new Bishop(5, 0, false));
		int[] B4 = {5,7};
		allPieces.put(B4 ,new Bishop(5, 7, true));
		
		// Queen Initialization
		int[] Q1 = {3,0};
		allPieces.put(Q1 ,new Queen(3, 0, false));
		int[] Q2 = {3,7};
		allPieces.put(Q2 ,new Queen(3, 7, true));
		
		// King Initialization
		int[] K1 = {4,0};
		allPieces.put(K1 ,new King(4, 0, false));
		int[] K2 = {4,7};
		allPieces.put(K2 ,new King(4, 7, true));
		
		for(Piece piece : allPieces.values()) {
			piece.findPossibleMoves(this);
		}
		
	}
	
	public HashMap<int[],Piece> getAllPieces(){
		return allPieces;
	}
	
	public boolean isAttacked(int[] position) {
		Collection<Piece> pieces = allPieces.values();
		Iterator<Piece> itr = pieces.iterator();
		ArrayList<String> possibleMoves;
		String posString = String.valueOf(position[0]) + String.valueOf(position[1]);
		while(itr.hasNext()) {
			possibleMoves = itr.next().getPossibleMoves();
			Iterator<String> possItr = possibleMoves.iterator();
			while(possItr.hasNext()) {
				String point = possItr.next();
				if(point.equals(posString))
					return true;
			}	
		}
		return false;
			
	}
	
	public void changePosition(int[] oldPosition) {
		Set<int[]> taken = allPieces.keySet();
		for (int[] pair : taken) {
			if (pair[0] == oldPosition[0] && pair[1] == oldPosition[1]) {
				Piece piece = allPieces.remove(pair);
				allPieces.put(piece.getPosition(), piece);
				break;
			}
		}
	}
	
	public int getPieceAtPosition(int[] position) {
		//
		if (allPieces.containsKey(position)) {
			if (allPieces.get(position).getIsBlack()) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return 0;
		}
	}
	
	public int inCheck() {
		Set<int[]> taken = allPieces.keySet();
		int[][] kingPositions = new int[2][2];
		int i = 0;
		King testKing = new King(0, 0, false); // Check for King class
		// Find both Kings
		for (int[] pair : taken) {
			if(allPieces.get(pair).getClass() == testKing.getClass()) {
				kingPositions[i] = pair;
				i++;
			}
		}
		
		// Set order of kingPositions to black then white
		if(!allPieces.get(kingPositions[0]).getIsBlack()) {
			int[] white = kingPositions[0];
			kingPositions[0] = kingPositions[1];
			kingPositions[1] = white;
		}
		
		if(this.isAttacked(kingPositions[0])) {
			return 1;
		}
		else if (this.isAttacked(kingPositions[1])) {
			return -1;
		}
		else {
			return 0;
		}
	}	
}
