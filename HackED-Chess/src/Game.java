import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;

public class Game {
	
	/*
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
			ByteBuffer buffer = ByteBuffer.allocate(8);
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
	*/
	
	
	
	public static void main(String[] args) {
		Board newGame = new Board();
		Player p1 = new Player(newGame, false);    // white
		p1.checkMoves();
		Player p2 = new Player(newGame, true);    // black
		p2.checkMoves();
		boolean isOver = false;
		boolean turn = true;
		try {
			// Connect to the pipe
			RandomAccessFile pipe = new RandomAccessFile("test.txt", "rw");
			while (!isOver) {
				if (turn) {
					String space = null;
					while(space==null)
						space = pipe.readLine();
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
					pipe.write(stringBuff.toString().getBytes());
					String moveTo = null;
					while(moveTo == null)
						moveTo = pipe.readLine();
			        for (int i = 0; i < 2; i++)
			            ch[i] = moveTo.charAt(i);
			        int[] strMoveTo = {Integer.parseInt(String.valueOf(ch[0])), Integer.parseInt(String.valueOf(ch[1]))};
					p1.move(point, strMoveTo);
					turn = false;
					if (newGame.inCheck()==1 && !p2.hasMoves()) {
						pipe.write("ww".getBytes());
						break;
					}
				}
				else {
					String space = null;
					while(space==null)
						space = pipe.readLine();
					char[] ch = new char[2];
			        for (int i = 0; i < 2; i++)
			            ch[i] = space.charAt(i);
			        int[] point = {Integer.parseInt(String.valueOf(ch[0])), Integer.parseInt(String.valueOf(ch[1]))};  
					ArrayList<String> possMoves = p2.getPiece(point).getPossibleMoves();
					StringBuffer stringBuff = new StringBuffer("");
					Iterator<String> itr = possMoves.iterator();
					while(itr.hasNext()) {
						stringBuff.append(itr.next());
					}
					pipe.write(stringBuff.toString().getBytes());
					String moveTo = null;
					while(moveTo == null)
						moveTo = pipe.readLine();
			        for (int i = 0; i < 2; i++)
			            ch[i] = moveTo.charAt(i);
			        int[] strMoveTo = {Integer.parseInt(String.valueOf(ch[0])), Integer.parseInt(String.valueOf(ch[1]))};
					p2.move(point, strMoveTo);
					turn = true;
					if (newGame.inCheck()==1 && !p1.hasMoves()) {
						pipe.write("wb".getBytes());
						break;
					}
				}
			}
		pipe.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
