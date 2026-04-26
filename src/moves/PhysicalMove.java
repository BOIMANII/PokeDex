package moves;

import pokemon.Type;

public class PhysicalMove extends Move{
	
	@Override
	public String getCategory() {
		return "Physical";
	}
	
	public PhysicalMove(String name, Type type, int power, int accuracy) {
		super(name, type, power, accuracy);
	}
	
}