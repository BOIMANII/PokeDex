package moves;

import pokemon.Type;

public class SpecialMove extends Move{
	@Override
	public String getCategory() {
		return "Special";
	}
	public SpecialMove(String name, Type type, int power, int accuracy) {
		super(name, type, power, accuracy);
	}
}
