package pokeDex;

public class PhysicalMove extends Move{
	
	@Override
	public String getCategory() {
		return "Physical";
	}
	
	public PhysicalMove(String name, String type, int power, int accuracy) {
		super(name, type, power, accuracy);
	}
	
}
