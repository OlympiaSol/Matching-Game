import java.util.Scanner;

class MemoryGame{
	public static void main(String args[]){
		int N = Integer.parseInt(args[0]);
		Board board = new Board(N);
		
		System.out.println("What type of game do you want?");
		System.out.println("Human vs Human or Human vs Computer?");
		System.out.println("Write human or computer");
		Scanner input = new Scanner(System.in);
		String type = input.nextLine();
		while(!type.equals("human") && !type.equals("computer")){
			System.out.println("Write human or computer");
			type = input.nextLine();
		}
		System.out.println("Write name for player 1");
		String name = input.nextLine();
		HumanPlayer player1 = new HumanPlayer(name);
		
		HumanPlayer human = null;
		ComputerPlayer computer = null;
		
		if(type.equals("human")){
			System.out.println("Write name for player 2");
			name = input.nextLine();
			human = new HumanPlayer(name);
		}else{
			System.out.println("Write name for computer");
			name = input.nextLine();
			computer = new ComputerPlayer(name, N);
		}
		
		while(!board.allPairsFound()){
			System.out.println();
			player1.play(board);
			if(!board.allPairsFound()){
				if(type.equals("human")){
					human.play(board);
				}else{
					computer.play(board);
				}
			}
			
			
			System.out.print(player1);
			System.out.print(" points: " + player1.getPoints() + "    ");
			if(type.equals("human")){
				System.out.print(human);
				System.out.print(" points: " + human.getPoints() + "\n");
			}else{
				System.out.print(computer);
				System.out.print(" points: " + computer.getPoints() + "\n");
			}
		}
		
		if(type.equals("human")){
			if (player1.getPoints() == human.getPoints()){
				System.out.println("No one wins (same points)");
			}else if(player1.getPoints() > human.getPoints()){
				System.out.println("Player " + player1 + " won!!");
			}else{
				System.out.println("Player " + human + " won!!");
			}
		}else{
			if (player1.getPoints() == computer.getPoints()){
				System.out.println("No one wins (same points)");
			}else if(player1.getPoints() > computer.getPoints()){
				System.out.println("Player " + player1 + " won!!");
			}else{
				System.out.println("Cumputer " + computer + " won!!");
			}
		}
	}
}