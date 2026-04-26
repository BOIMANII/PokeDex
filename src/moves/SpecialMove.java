package moves;

import pokemon.*;

public class SpecialMove extends Move {
	@Override
	public String getCategory() {
		return "Special";
	}

	public SpecialMove(String name, Type type, int power, int accuracy, StatusCondition statusEffect,
			double statusChance, boolean affectsUser) {
		super(name, type, power, accuracy);
		setStatusChance(statusChance);
		setStatusEffect(statusEffect);
		setStatAffectsUser(affectsUser);
	}

	public SpecialMove(String name, Type type, int power, int accuracy, String statAffected, int statStages,
			double statusChance, boolean affectsUser) {
		super(name, type, 0, accuracy);
		setStatusChance(statusChance);
		setStatAffected(statAffected);
		setStatStages(statStages);
		setStatAffectsUser(affectsUser);
	}

	public SpecialMove(String name, Type type, int power, int accuracy) {
		super(name, type, power, accuracy);
	}
}