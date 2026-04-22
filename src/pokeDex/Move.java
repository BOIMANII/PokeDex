/**
 * @author Max
 * @author Andy
 * @author Anthony
 * @date 2026-04-10
 * @teacher Mr. Smintich
 * 
 * This is the move class of the pokemon assignment
 * Abstract class extended by StatusMove, SpecialMove, PhysicalMove
 * Implements Printable
 */

package pokeDex;

public abstract class Move implements Printable {

	private String name;
	private String type;
	private int power;
	private int accuracy;
//	private StatusCondition statusEffect; 
	private double statusChance = 0.0;
	private String statAffected;
	private int statStages = 0;

	private boolean statAffectsUser = false;
	
	// Constructor for each variable
	public Move(String name, String type, int power, int accuracy) {
		setName(name);
		setType(type);
		setPower(power);
		setAccuracy(accuracy);
	}

	// Getters for each variable
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public int getPower() {
		return power;
	}

	public int getAccuracy() {
		return accuracy;
	}

	// Methods
	public abstract String getCategory();

	@Override
	public void printInfo() {
		System.out.println("Move name: " + name);
		System.out.println("Type: " + type);
		System.out.println("Category: " + getCategory());
		System.out.println("Power: " + power);
		System.out.println("Accuracy: " + accuracy);
	}

	// Setters for each variable
	public void setName(String name) {
		this.name = name;
	}

	public void setType(String typeSelected) {
		String[] types = { "NORMAL", "FIRE", "WATER", "GRASS", "ELECTRIC", "ICE", "FIGHTING", "POISON", "GROUND",
				"FLYING", "PSYCHIC", "BUG", "ROCK", "GHOST", "DRAGON", "STEEL", "DARK", "Fairy" };
		for (String type : types) {
			if (type.equalsIgnoreCase(typeSelected)) {
				this.type = typeSelected;
				return;
			}
		}
		System.out.println("Invalid type entry: Must choose from existing types");
	}

	public void setPower(int power) {
		if (power >= 0) {
			this.power = power;
			return;
		}
		System.out.println("Invalid power entry: Power cannot be negative");
	}

	public void setAccuracy(int accuracy) {
		if (accuracy >= 0 && accuracy <= 100) {
			this.accuracy = accuracy;
			return;
		}
		System.out.println("Invalid accuracy entry: Must be between 0 and 100 inclusive");
	}

}
