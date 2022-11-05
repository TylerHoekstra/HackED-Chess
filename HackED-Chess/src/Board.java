import java.util.HashMap;
import java.util.Set;

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
	}
	
	public HashMap<int[],Piece> getAllPieces(){
		return allPieces;
	}
	
	public void changePosition(int[] oldPosition) {
		Set<int[]> taken = allPieces.keySet();
		for (int[] pair : taken) {
			if (pair[0] == oldPosition[0] || pair[1] == oldPosition[1]) {
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
		
	
}
