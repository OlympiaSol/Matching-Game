import java.util.Scanner;

class HumanPlayer{
	private String name;
	private int points;
	
	public HumanPlayer(String name){
		this.name = name;
		points = 0;
	}
	
	public void play(Board board){
		Scanner input = new Scanner(System.in);
		System.out.print(name + ", select two positions to open: ");
		int pos1 = input.nextInt();
		int pos2 = input.nextInt();
		while(pos1 == pos2 || !board.containsCards(pos1) || !board.containsCards(pos2)){
			System.out.println("Selection not valid\n");
			System.out.print(name + ", select two positions to open: ");
			pos1 = input.nextInt();
			pos2 = input.nextInt();
		}
		
		boolean foundPair = board.openPositions(pos1, pos2);
		if(foundPair == true){
			points++;
		}
	}
	
	public int getPoints(){
		return points;
	}
	
	public String toString(){
		return name;
	}
}