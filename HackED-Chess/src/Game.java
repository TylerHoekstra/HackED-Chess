public class Game {
	
	public static void main(String[] args) {
		Board newGame = new Board();
		Player p1 = new Player(false);    // white
		Player p2 = new Player(true);    // black
		boolean isOver = false;
		boolean turn = true;
		int winner = 0;
		while (!isOver) {
			if (turn) {
				p1.move();
			} else {
				p2.move();
			}
			if (newGame.inCheckmate()) {
				winner = 1;
				break;
			} else if (newGame.inStalemate()) {
				winner = 0;
				break;
			}
		}
	}

}
