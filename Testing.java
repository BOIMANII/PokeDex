package pokeDex;

public class Testing {
	
	public static void main(String[] args) {
		
		PhysicalMove move = new PhysicalMove("5 nights at Epstein's", Type.FIRE, 88, 100);
		move.printInfo();
		System.out.println(move.getCategory());
		
	}

}
