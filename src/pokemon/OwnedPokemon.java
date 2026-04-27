/**
 * @author Anthony
 * @date 2026-04-10
 * @teacher Mr. Smintich
 * 
 * This is the OwendPokemon class of the pokemon assignment
 * Implements Printable
 */
package pokemon;

import moves.*;

public class OwnedPokemon implements Printable {

	private Pokemon base;
	private String name;
	private int level;
	private Move[] moves;
	private int maxHp, currentHp;
	private int currentAtk, currentDef, currentSpA, currentSpD, currentSpe;
	private StatusCondition status = StatusCondition.NONE;
	private int sleepCounter;
	private int atkStageN = 2;
	private int atkStageD = 2;
	private double atkStage = atkStageN / atkStageD;
	private int defStageN = 2;
	private int defStageD = 2;
	private double defStage = defStageN / defStageD;
	private int speStageN = 2;
	private int speStageD = 2;
	private double speStage = speStageN / speStageD;

//    normal constructor, with level validation.
	public OwnedPokemon(Pokemon base, int level, Move[] moves) {
		this.base = base;

		if (level < 1 || level > 100) {
			System.out.println("Invalid level. Defaulting to 1.");
			this.level = 1;
		} else {
			this.level = level;
		}

		this.moves = moves;
		recalculateStats();
	}

//    overloaded constructor that defaults to lvl 50
	public OwnedPokemon(Pokemon base, Move[] moves) {
		this(base, 50, moves);
	}

	/**
	 * Calculate's pokemon's stats based on level
	 * Uses hp formula for calculated HP
	 * Uses stats formula for calculating all other stats
	 * 
	 * @param
	 * @return
	 */
	private void recalculateStats() {
		this.maxHp = (2 * base.getHp() * level) / 100 + level + 10;
		this.currentHp = this.maxHp; // sets current to max
		this.currentAtk = (2 * base.getAtk() * level) / 100 + 5;
		this.currentDef = (2 * base.getDef() * level) / 100 + 5;
		this.currentSpA = (2 * base.getSpA() * level) / 100 + 5;
		this.currentSpD = (2 * base.getSpD() * level) / 100 + 5;
		this.currentSpe = (2 * base.getSpe() * level) / 100 + 5;
	}

	/**
	 * Prints the pokemon's stats beautifully.
	 * 
	 * @param
	 * @return
	 */
	@Override
	public void printInfo() {
		System.out.println("--- Pokemon Info ---");
		System.out.println("Name     : " + base.getName());
		System.out.println("Level    : " + level);
		if (base.getType2() == Type.NONE) {
			System.out.println("Type     : " + base.getType1());
		} else {
			System.out.println("Type 1     : " + base.getType1());
			System.out.println("Type 2     : " + base.getType2());
		}

		// Build move name list
		System.out.print("Moves    : ");
		for (int i = 0; i < moves.length; i++) {
			System.out.print(moves[i].getName());
			if (i < moves.length - 1)
				System.out.print(", ");
		}
		System.out.println();

		System.out.println("HP       : " + currentHp + " / " + maxHp);
		System.out.println("Attack   : " + currentAtk);
		System.out.println("Defense  : " + currentDef);
		System.out.println("Sp. Atk  : " + currentSpA);
		System.out.println("Sp. Def  : " + currentSpD);
		System.out.println("Speed    : " + currentSpe);
		System.out.println("--------------------\n");
	}
	
	/**
	 * Prints short overview of pokemon beautifully
	 * 
	 * @param
	 * @return
	 */
	public void printInfoSimple() {
		System.out.println("--- Pokemon Info ---");
		System.out.println("Name     : " + base.getName());
		System.out.println("HP       : " + currentHp + " / " + maxHp);
		// Build move name list
		System.out.print("Moves    : ");
		for (int i = 0; i < moves.length; i++) {
			System.out.print(moves[i].getName());
			if (i < moves.length - 1)
				System.out.print(", ");
		}
		System.out.println("\n--------------------\n");

	}

	// Getters
	public String getName() {
		return name;
	}

	public Pokemon getBase() {
		return base;
	}

	public int getLevel() {
		return level;
	}

	public Move[] getMoves() {
		return moves;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public int getCurrentAtk() {
		return currentAtk;
	}

	public int getCurrentDef() {
		return currentDef;
	}

	public int getCurrentSpA() {
		return currentSpA;
	}

	public int getCurrentSpD() {
		return currentSpD;
	}

	public int getCurrentSpe() {
		return currentSpe;
	}

	public StatusCondition getStatus() {
		return status;
	}

	/**
	 * Multiplies current attack by attack stage calculation, and halves it if
	 * pokemon is burned
	 * 
	 * @param
	 * @return int
	 */
	public int getEffectiveAtk() {
		if (status.equals(StatusCondition.BURNED)) {
			return (int) (currentAtk * atkStage) / 2;
		}
		return (int) (currentAtk * atkStage);
	}

	public int getEffectiveDef() {
		return (int) (currentDef * defStage);
	}

	public int getEffectiveSpe() {
		if (status.equals(StatusCondition.PARALYZED)) {
			return (int) ((currentSpe * speStage) / 2);
		}
		return (int) (currentSpe * speStage);
	}

	public int getSleepCounter() {
		return sleepCounter;
	}

	// setCurrentHp, validation within bounds
	public void setCurrentHp(int hp) {
		if (hp < 0)
			this.currentHp = 0;
		else if (hp > maxHp)
			this.currentHp = maxHp;
		else
			this.currentHp = hp;
	}

	// setLevel, validates then recalculates within bounds.
	public void setLevel(int level) {
		if (level < 1 || level > 100) {
			System.out.println("Invalid level. No change made.");
			return;
		}
		this.level = level;
		recalculateStats();
	}

	public void setSleepCounter(int i) {
		this.sleepCounter = i;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void applyStatus(StatusCondition s) {
		this.status = s;
		if (status.equals(StatusCondition.ASLEEP)) {
			sleepCounter = (int) (Math.random() * (3 - 1 + 1)) + 1;
		}
	}
	
	/**
	 * A base stage is the fraction 2/2
	 * For each increase in a stage, the numerator is incremented by 1
	 * For each decrease, denominator incremented by 1
	 * Both can be incremented to a max of 6
	 * This statStage is then multiplied to stats to determine effective stats
	 * 
	 * @param String stat
	 * @param int stages
	 * @return
	 */
	public void applyStatChange(String stat, int stages) {
		if (stat.equalsIgnoreCase("atk")) {
			if (stages > 0) {
				this.atkStageN = this.atkStageN + stages;
				if (this.atkStageN > 6) {
					this.atkStageN = 6;
				}
			} else if (stages < 0) {
				this.atkStageD = this.atkStageD - stages;
				if (this.atkStageD > 6) {
					this.atkStageD = 6;
				}
			}
		} // TODO
		if (stat.equalsIgnoreCase("def")) {
			if (stages > 0) {
				this.defStageN = this.defStageN + stages;
				if (this.defStageN > 6) {
					this.defStageN = 6;
				}
			} else if (stages < 0) {
				this.defStageD = this.defStageD - stages;
				if (this.defStageD > 6) {
					this.defStageD = 6;
				}
			}
		}
		if (stat.equalsIgnoreCase("spe")) {
			if (stages > 0) {
				this.speStageN = this.speStageN + stages;
				if (this.speStageN > 6) {
					this.speStageN = 6;
				}
			} else if (stages < 0) {
				this.speStageD = this.speStageD - stages;
				if (this.speStageD > 6) {
					this.speStageD = 6;
				}
			}
		}
	}

	public void applyEndOfTurnEffects() {
		if (status.equals(StatusCondition.BURNED) || status.equals(StatusCondition.POISONED)) {
			this.currentHp -= maxHp * (1 / 16);
			if (currentHp < 0) {
				this.currentHp = 0;
			}
		}
		if (status.equals(StatusCondition.ASLEEP)) {
			sleepCounter -= 1;
			if (sleepCounter == 0) {
				this.status = StatusCondition.NONE;
			}
		}
	}

	public void resetBattleState() {
		currentHp = maxHp;
		atkStage = 0;
		defStage = 0;
		speStage = 0;
		sleepCounter = 0;
		status = StatusCondition.NONE;
	}

	public boolean isFainted() {
		return currentHp == 0;
	}
}