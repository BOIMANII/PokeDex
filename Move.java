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

public abstract class Move implements Printable{
	
	private String name;
	private Type type;
	private int power;
	private int accuracy;
	
	// Constructor for each variable
	public Move(String name, Type type, int power, int accuracy) {
		setName(name);
		setType(type);
		setPower(power);
		setAccuracy(accuracy);
	}
	
	// Getters for each variable
	public String getName() {return name;}
	public Type getType() {return type;}
	public int getPower() {return power;}
	public int getAccuracy() {return accuracy;}
	
	// Methods
	public abstract String getCategory();
	
	/**
	 * Prints information on the move
	 * 
	 * @param
	 * @return
	 */
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
	
	/**
	 * Setter for type
	 * Data validation - only one of the 18 types are valid
	 * 
	 * @param typeSelected The type of the move entered when the move object is initialized
	 */
	public void setType(Type typeSelected) {
		this.type = typeSelected;
	}
	
	/**
	 * Setter for power with in built data validation
	 * Power is an integer 0 or above
	 * 
	 * @param power inputed power of the move
	 */
	public void setPower(int power) {
		if (power >= 0) {
			this.power = power;
			return;
		}
		System.out.println("Invalid power entry: Power cannot be negative");
	}
	
	/**
	 * Setter for accuracy
	 * Data validation - accuracy is an integer between 0 and 100 inclusive
	 * 
	 * @param accuracy
	 */
	public void setAccuracy(int accuracy) {
		if (accuracy >= 0 && accuracy <= 100) {
			this.accuracy = accuracy;
			return;
		}
		System.out.println("Invalid accuracy entry: Must be between 0 and 100 inclusive");
	}

}
