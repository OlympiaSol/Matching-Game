import java.util.Random;

public class Board {
	private int N;
	private int[] cards;
	private int[] cardsExist;
	private int leftPairds;
	private Random random;
	private String message;
	private String message2;
	
	public Board(int N) {
		this.N = N;
		cards = new int[N*2];
		cardsExist = new int[N*2];
		leftPairds = N;
		random = new Random();
		message = " ";
		message2 = "";
		for(int i = 0; i < 2*N; i++) {
			message+=i+"   ";
			message2+="----";
		}
		int[] putCard = new int[N*2];
		for(int i = 0; i<2; i++) {
			int count = 0;
			while (count != N) {
				int position = random.nextInt(N*2);
				if(putCard[position] == 1) {
					continue;
				}
				putCard[position] = 1;
				cards[position] = count;
				count++;
			}
		}
	}
	
	public void print() {
		System.out.println();
		System.out.println(message);
		System.out.println(message2);
		System.out.print(" ");
		for(int i = 0; i < N*2; i++) {
			if(cardsExist[i] == 0) {
				System.out.print("*   ");
			}else {
				System.out.print("    ");
			}
		}
		System.out.println("\n");
	}
	
	public void flash(int pos1, int pos2) {
		System.out.println();
		System.out.println(message);
		System.out.println(message2);
		System.out.print(" ");
		for(int i = 0; i < N*2; i++) {
			if(i == pos1 || i == pos2) {
				System.out.print(cards[i] + "   ");
			}else if(cardsExist[i] == 0) {
				System.out.print("*   ");
			}else if(cardsExist[i] == 1) {
				System.out.print("    ");
			}
		}
		delay(10);
		System.out.print('\r');
		System.out.print(" ");
		for(int i = 0; i < N*2; i++) {
			if(cardsExist[i] == 0) {
				System.out.print("*   ");
			}else {
				System.out.print("    ");
			}
		}
		System.out.println("\n");
	}
	
	private void delay(int sec){
		try {
			Thread.currentThread().sleep(1000*sec);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public boolean openPositions(int pos1, int pos2) {
		if(cards[pos1] == cards[pos2]) {
			System.out.println("Found pair (" + cards[pos1] + "," + cards[pos1] + ")");
			cardsExist[pos1] = 1;
			cardsExist[pos2] = 1;
			print();
			leftPairds--;
			return true;
		}else {
			flash(pos1, pos2);
			return false;
		}
	}
	
	public int getRandomPosition() {
		while(true) {
			int randomPos = random.nextInt(N*2);
			if(cardsExist[randomPos] == 0) {
				return randomPos;
			}
		}
	}
	
	public int getRandomPosition(int pos) {
		while(true) {
			int randomPos = random.nextInt(N*2);
			if(cardsExist[randomPos] == 0 && randomPos != pos) {
				return randomPos;
			}
		}
	}
	
	public boolean containsCards(int pos) {
		if(pos<0 || pos>=2*N){
			return false;
		}
		if(cardsExist[pos] == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public int getCard(int pos) {
		return cards[pos];
	}
	
	public boolean allPairsFound() {
		if(leftPairds == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String args[]) {
		int N = 3;
		Board board = new Board(N);
		board.print();
		for(int i = 0; i < N*2; i++) {
			System.out.println(board.getCard(i));
		}
		int pos1 = board.getRandomPosition();
		int pos2 = board.getRandomPosition(pos1);
		System.out.println("Two random positions (" + pos1 + "," + pos2 + ")");
		board.openPositions(pos1, pos2);
		pos1 = board.getRandomPosition();
		pos2 = board.getRandomPosition(pos1);
		System.out.println("Two random positions (" + pos1 + "," + pos2 + ")");
		board.openPositions(pos1, pos2);
		
	}
}
