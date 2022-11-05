import java.util.ArrayList;
public abstract class Piece {

	protected int[] Position = new int[2];
	protected ArrayList<String> possibleMoves = new ArrayList<String>(); 
	
	public int[] getPosition() {
		return Position;
	}
	
	public ArrayList<String> getPossibleMoves(){
		return possibleMoves;
	}
	
	public abstract void move();
}
