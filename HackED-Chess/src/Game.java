public class Game {
	
	public static void main(String[] args) {
		Board newGame = new Board();
		Player p1 = new Player(false, newGame);    // white
		Player p2 = new Player(true, newGame);    // black
		boolean isOver = false;
		boolean turn = true;
		int winner = 0;
		while (!isOver) {
			if (turn) {
				p1.move();
				if (newGame.inCheck()==1 && !p2.hasMoves()) {
					winner = 1;
					break;
				}
			}
			else {
				p2.move();
				if (newGame.inCheck()==-1 && !p1.hasMoves()) {
					winner = -1;
					break;
				}
			}
		}
	}
}
