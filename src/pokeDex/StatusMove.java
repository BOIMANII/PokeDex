/**
 * Name: Max Hao
 * Date: 2026-04-17
 * Description: Status move subclass of Move.java
 */

package pokeDex;

public class StatusMove extends Move{
	
	public StatusMove(String name, Type type, int accuracy) {
		super(name, type, 0, accuracy);
	}
	
	@Override
	public String getCategory() {
		return "Status";
	}

}
