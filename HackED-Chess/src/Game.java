import java.nio.channels.Pipe;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

public class Game {
	
	public static void outputPipe(String command){
		try {
			Pipe pipe = Pipe.open();
			Pipe.SinkChannel sink = pipe.sink();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			buffer.clear();
			buffer.put(command.getBytes());
			buffer.flip();
			while(buffer.hasRemaining()) {
		         sink.write(buffer);
		    }
		}
		catch(IOException e) {
			System.err.println("Pipe IOException");
		}
	}
	
	public static String inputPipe(){
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
		    }
			return buffer.toString();
		}
		catch(IOException e) {
			System.err.println("Pipe IOException");
		}
		return null;
	}
	
	public static void main(String[] args) {
		Board newGame = new Board();
		Player p1 = new Player(newGame, false);    // white
		Player p2 = new Player(newGame, true);    // black
		boolean isOver = false;
		boolean turn = true;
		while (!isOver) {
			if (turn) {
				String space = inputPipe();
				char[] ch = new char[2];
		        for (int i = 0; i < 2; i++)
		            ch[i] = space.charAt(i);
		        int[] point = {Integer.parseInt(String.valueOf(ch[0])), Integer.parseInt(String.valueOf(ch[1]))};  
				ArrayList<String> possMoves = p1.getPiece(point).getPossibleMoves();
				StringBuffer stringBuff = new StringBuffer("");
				Iterator<String> itr = possMoves.iterator();
				while(itr.hasNext()) {
					stringBuff.append(itr.next());
				}
				outputPipe(stringBuff.toString());
				String moveTo = inputPipe();
		        for (int i = 0; i < 2; i++)
		            ch[i] = moveTo.charAt(i);
		        int[] strMoveTo = {Integer.parseInt(String.valueOf(ch[0])), Integer.parseInt(String.valueOf(ch[1]))};
				p2.move(point, strMoveTo);
				if (newGame.inCheck()==1 && !p2.hasMoves()) {
					outputPipe("ww");
					break;
				}
			}
			else {
				String space = inputPipe();
				char[] ch = new char[2];
		        for (int i = 0; i < 2; i++)
		            ch[i] = space.charAt(i);
		        int[] point = {Integer.parseInt(String.valueOf(ch[0])), Integer.parseInt(String.valueOf(ch[1]))};  
				ArrayList<String> possMoves = p1.getPiece(point).getPossibleMoves();
				StringBuffer stringBuff = new StringBuffer("");
				Iterator<String> itr = possMoves.iterator();
				while(itr.hasNext()) {
					stringBuff.append(itr.next());
				}
				outputPipe(stringBuff.toString());
				String moveTo = inputPipe();
		        for (int i = 0; i < 2; i++)
		            ch[i] = moveTo.charAt(i);
		        int[] strMoveTo = {Integer.parseInt(String.valueOf(ch[0])), Integer.parseInt(String.valueOf(ch[1]))};
				p1.move(point, strMoveTo);
				if (newGame.inCheck()==-1 && !p1.hasMoves()) {
					outputPipe("wb");
					break;
				}
			}
		}
	}
}
