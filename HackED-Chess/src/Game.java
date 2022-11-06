import java.nio.channels.Pipe;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Game {
	
	public static void inputPipe(){
		try {
			Pipe pipe = Pipe.open();
			Pipe.SinkChannel sink = pipe.sink();
			String test = "This is a test";
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.clear();
			buffer.put(test.getBytes());
			buffer.flip();
			while(buffer.hasRemaining()) {
		         sink.write(buffer);
		    }
		}
		catch(IOException e) {
			System.err.println("Pipe IOException");
		}
	}
	
	public static void outputPipe(){
		try {
			Pipe pipe = Pipe.open();
			Pipe.SourceChannel source = pipe.source();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while(source.read(buffer) > 0){
				 buffer.flip();
		         while(buffer.hasRemaining()){
		            char ch = (char) buffer.get();
		            System.out.print(ch);
		         }
		         buffer.clear();
		    }
		}
		catch(IOException e) {
			System.err.println("Pipe IOException");
		}
	}
	
	public static void main(String[] args) {
		
		inputPipe();
		outputPipe();
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
