/**
 * @author Max
 * @author Andy
 * @author Anthony
 * @date 2026-04-10
 * @teacher Mr. Smintich
 * 
 * This is the Trainer class of the pokemon assignment
 * A part of Package:Battle
 * Used by engine for AI.
 */
package battle;

import pokemon.*;

public class Trainer {
//	defining Variables/Attributes
	private String name;
	private OwnedPokemon[] team;
	private int activePokemonIndex;

	public Trainer(String name, OwnedPokemon[] arr) {
		this.name = name;
		this.team = arr;
		this.activePokemonIndex = 0;
	}

//	Getters
	public String getName() {
		return name;
	}

	public OwnedPokemon[] getTeam() {
		return team;
	}

	public OwnedPokemon getActivePokemon() {
		return team[activePokemonIndex];
	}

	// This method determines lost by checking Faint status of all 3 team members.
	public boolean hasLost() {
		return team[0].isFainted() && team[1].isFainted() && team[2].isFainted();
	}

//	This method switches to next available pokemon
	public void switchToNext() {
		if (team[activePokemonIndex].isFainted()) {
			if (activePokemonIndex == 2) {
				activePokemonIndex = 0;
			} else {
				activePokemonIndex++;
			}
		}
	}

// Prints out team Information in an organized manner
	public void printTeam() {
		for (OwnedPokemon i : team) {
			String tmp = "Name: " + i.getBase().getName();
			System.out.println(tmp);
			for (int i1 = 0; i1 < tmp.length(); i1++) {
				// makes the dashed line an appropiate length.
				System.out.print("-");
			}
			System.out.println();
			System.out.println("Health: " + i.getCurrentHp());
			System.out.println("Status: " + i.getStatus());
		}
	}

}