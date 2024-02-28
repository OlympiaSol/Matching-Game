class ComputerPlayer{
	private String name;
	private int[] seenCard;
	private int points;
	
	public ComputerPlayer(String name, int N){
		this.name = name;
		points = 0;
		seenCard = new int[N];
		for(int i = 0; i < N; i++){
			seenCard[i] = -1;
		}
	}
	
	public void play(Board board){
		int pos1 = board.getRandomPosition();
		int pos2;
		if(seenCard[board.getCard(pos1)] !=-1 && seenCard[board.getCard(pos1)] != pos1){
			pos2 = seenCard[board.getCard(pos1)];
		}else{
			pos2 = board.getRandomPosition(pos1);
		}
		
		System.out.println("Computer player " + name + " selected positions :" + pos1 + " " + pos2);
		boolean foundPair = board.openPositions(pos1, pos2);
		if(foundPair == false){
			seenCard[board.getCard(pos1)] = pos1;
			seenCard[board.getCard(pos2)] = pos2;
		} else{
			points++;
		}
	}
	
	public int getPoints(){
		return points;
	}
	
	public String toString(){
		return name;
	}
	
	public static void main(String args[]) {
		int N = 3;
		Board board = new Board(N);
		board.print();
		for(int i = 0; i < N*2; i++) {
			System.out.println(board.getCard(i));
		}
		ComputerPlayer computer = new ComputerPlayer("HAL", N);
		
		
		computer.play(board);
		computer.play(board);
		computer.play(board);
	}
}