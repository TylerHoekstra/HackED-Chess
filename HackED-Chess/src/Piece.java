import java.util.ArrayList;
public abstract class Piece {

	protected boolean isBlack;
	protected int[] position = new int[2];
	protected ArrayList<String> possibleMoves = new ArrayList<String>();
	
	protected Piece(int x, int y, boolean isBlack) {
		position[0] = x;
		position[1] = y;
		this.isBlack = isBlack;
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
