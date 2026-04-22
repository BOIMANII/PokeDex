/**
 * @author Andy
 * @author Max
 * @author Anthony
 * @date 2026-04-10
 * @teacher Mr. Smintich
 * 
 * Main class of the Pokemon battle game program
 * Initializes and uses each other class apart from Move.java
 */

package pokeDex;

public class Main {
	
	public static void main(String[] args) {
		
		// Declare + Initialize Pokemons
		// Variable in order: Name PokeDex Type1 Type2 hp attack defense spA spD spE
		Pokemon charizard = new Pokemon("Charizard", 6, "FIRE", "FLYING", 78, 84, 78, 109, 85, 100);
		Pokemon venusaur = new Pokemon("Venusaur", 3, "GRASS", "POISON", 80, 82, 83, 100, 100, 80);

//		Charizard MoveSet
		Move airSlash = new SpecialMove("Air Slash", "FLYING", 75, 95);
		Move dragonClaw = new PhysicalMove("Dragon Claw", "DRAGON", 80, 100);
		Move ember = new SpecialMove("Ember", "FIRE", 40, 100);
		Move smokeScreen = new StatusMove("SmokeScreen", "NORMAL", 100);
//		Venusaur MoveSet
		Move petalBlizzard = new PhysicalMove("Petal Blizzard", "GRASS", 90, 100);
		Move growl = new StatusMove("Growl", "NORMAL", 100);
		Move sludgeWave = new SpecialMove("Sludge Wave", "Poison", 95, 100);
		Move vineWhip = new PhysicalMove("Vine Whip", "GRASS", 45, 100);
		
		// Create 2 OwnedPokemon objects
		// Variables in order: Pokemon base, int level, Move[] moves
		Move[] charizardMoves = {airSlash, dragonClaw, ember, smokeScreen};
		OwnedPokemon ownedCharizard = new OwnedPokemon(charizard, 88, charizardMoves);
		Move[] venusaurMoves = {petalBlizzard, growl, sludgeWave, vineWhip};
		OwnedPokemon ownedVenusaur = new OwnedPokemon(venusaur, venusaurMoves);
		
		// Call printInfo() on each OwnedPokemon object to display their computed stats
		ownedCharizard.printInfo();
		ownedVenusaur.printInfo();
		
		// Call setLevel() to change one OwnedPokemon's level, then call printInfo() again and confirm the stats changed
		ownedVenusaur.setLevel(67);
		ownedVenusaur.printInfo();
		
		// Call setCurrentHp(0) on one OwnedPokemon and use isFainted() to confirm it returns true
		ownedVenusaur.setCurrentHp(0);
		System.out.println("Is venusaur fainted? " + ownedVenusaur.isFainted());
		
	}	

}
