import java.util.ArrayList;
public abstract class Piece {

	protected int[] position = new int[2];
	protected ArrayList<String> possibleMoves = new ArrayList<String>();
	
	protected Piece(int x, int y) {
		position[0] = x;
		position[1] = y;
	}
	
	public int[] getPosition() {
		return position;
	}
	
	public ArrayList<String> getPossibleMoves(){
		return possibleMoves;
	}
	
	public abstract void move();
	
	public abstract void findPossibleMoves();
}
