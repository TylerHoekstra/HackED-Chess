import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
		Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext() && !isOver){
            // Receive data from Python code 
            if (turn) {
				String space = scanner.nextLine();
				char[] ch = new char[2];
		        for (int i = 0; i < 2; i++)
		            ch[i] = space.charAt(i);
		        int[] point = {Integer.parseInt(String.valueOf(ch[0])), Integer.parseInt(String.valueOf(ch[1]))};  
				ArrayList<String> possMoves = p1.getPiece(point).getPossibleMoves();
				StringBuffer stringBuff = new StringBuffer("");
				Iterator<String> itr = possMoves.iterator();
				while(itr.hasNext()) {
					stringBuff.append(itr.next() + " ");
				}
				System.out.println(stringBuff.toString());
				String moveTo = scanner.nextLine();
		        for (int i = 0; i < 2; i++)
		            ch[i] = moveTo.charAt(i);
		        int[] strMoveTo = {Integer.parseInt(String.valueOf(ch[0])), Integer.parseInt(String.valueOf(ch[1]))};
				p1.move(point, strMoveTo);
				turn = false;
				if (newGame.inCheck()==1 && !p2.hasMoves()) {
					System.out.println("ww");
					break;
				}
			}
            else {
            	String space = scanner.nextLine();
				char[] ch = new char[2];
		        for (int i = 0; i < 2; i++)
		            ch[i] = space.charAt(i);
		        int[] point = {Integer.parseInt(String.valueOf(ch[0])), Integer.parseInt(String.valueOf(ch[1]))};  
				ArrayList<String> possMoves = p2.getPiece(point).getPossibleMoves();
				StringBuffer stringBuff = new StringBuffer("");
				Iterator<String> itr = possMoves.iterator();
				while(itr.hasNext()) {
					stringBuff.append(itr.next() + " ");
				}
				System.out.println(stringBuff.toString());
				String moveTo = scanner.nextLine();
		        for (int i = 0; i < 2; i++)
		            ch[i] = moveTo.charAt(i);
		        int[] strMoveTo = {Integer.parseInt(String.valueOf(ch[0])), Integer.parseInt(String.valueOf(ch[1]))};
				if(newGame.getPieceAtPosition(point)==-1) {
					Piece removePiece = p1.getPiece(point);
					newGame.remPiece(point);
					p1.remPiece(removePiece);
				}
		        p2.move(point, strMoveTo);
				turn = false;
				if (newGame.inCheck()==1 && !p1.hasMoves()) {
					System.out.println("wb");
					break;
				}
            }
		}
        scanner.close();
	}
}
