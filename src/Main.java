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


import moves.Move;
import moves.PhysicalMove;
import moves.SpecialMove;
import moves.StatusMove;
import pokemon.OwnedPokemon;
import pokemon.Pokemon;
import pokemon.Type;

public class Main {
	
	public static void main(String[] args) {
		
		// Declare + Initialize Pokemons
		// Variable in order: Name PokeDex Type1 Type2 hp attack defense spA spD spE
		Pokemon charizard = new Pokemon("Charizard", 6, Type.FIRE, Type.FLYING, 78, 84, 78, 109, 85, 100);
		Pokemon venusaur = new Pokemon("Venusaur", 3, Type.GRASS, Type.POISON, 80, 82, 83, 100, 100, 80);

//		Charizard MoveSet
		Move airSlash = new SpecialMove("Air Slash", Type.FLYING, 75, 95);
		Move dragonClaw = new PhysicalMove("Dragon Claw", Type.DRAGON, 80, 100);
		Move ember = new SpecialMove("Ember", Type.FIRE, 40, 100);
		Move smokeScreen = new StatusMove("SmokeScreen", Type.NORMAL, 100);
//		Venusaur MoveSet
		Move petalBlizzard = new PhysicalMove("Petal Blizzard", Type.GRASS, 90, 100);
		Move growl = new StatusMove("Growl", Type.NORMAL, 100);
		Move tackle = new PhysicalMove("Tackle", Type.NORMAL , 40, 100);
		Move vineWhip = new PhysicalMove("Vine Whip", Type.GRASS, 45, 100);
		
		// Create 2 OwnedPokemon objects
		// Variables in order: Pokemon base, int level, Move[] moves
		Move[] charizardMoves = {airSlash, dragonClaw, ember, smokeScreen};
		OwnedPokemon ownedCharizard = new OwnedPokemon(charizard, 88, charizardMoves);
		Move[] venusaurMoves = {petalBlizzard, growl, tackle, vineWhip};
		OwnedPokemon ownedVenusaur = new OwnedPokemon(venusaur, venusaurMoves);
		
		// Call printInfo() on each OwnedPokemon object to display their computed stats
		ownedCharizard.printInfo();
		ownedVenusaur.printInfo();
		
		// Call setLevel() to change one OwnedPokemon's level, then call printInfo() again and confirm the stats changed
		ownedVenusaur.setLevel(67);
		venusaur.printInfo();
		
		// Call setCurrentHp(0) on one OwnedPokemon and use isFainted() to confirm it returns true
		ownedVenusaur.setCurrentHp(0);
		System.out.println("Is venusaur fainted? " + ownedVenusaur.isFainted());
		
	}	

}
