/**
 * Name: Max Hao
 * Date: 2026-04-17
 * Description: Status move subclass of Move.java
 */

package moves;
import pokemon.*;
public class StatusMove extends Move {

	public StatusMove(String name, Type type, int accuracy) {
		super(name, type, 0, accuracy);
	}

	public StatusMove(String name, Type type, int accuracy, StatusCondition statusEffect, double statusChance,
			boolean affectsUser) {
		super(name, type, 0, accuracy);
		setStatusChance(statusChance);
		setStatusEffect(statusEffect);
		setStatAffectsUser(affectsUser);

	}

	public StatusMove(String name, Type type, int accuracy, String statAffected, int statStages, double statusChance,
			boolean affectsUser) {
		super(name, type, 0, accuracy);
		setStatusChance(statusChance);
		setStatAffected(statAffected);
		setStatStages(statStages);
		setStatAffectsUser(affectsUser);

	}

	@Override
	public String getCategory() {
		return "Status";
	}

}