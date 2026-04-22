package pokeDex;
import java.util.ArrayList;

/**
 * @author Andy
 * @author Max
 * @author Anthony
 * @date 10 04 2026
 * @teacher Mr. Smintich
 */

public class Main {
	
	private static ArrayList<Pokemon> Collection = new ArrayList(); // Define Collection ArrayList
	
	private static ArrayList<Move> Moves = new ArrayList(); // Define Move Collection
	public static void main(String[] args) {
		
		// Declare + Initialize Pokemons
		// Variable in order: Name PokeDex Type1 Type2 hp attack defense spA spD spE
		Pokemon Charizard = new Pokemon("Charizard", 6, "FIRE", "FLYING", 78, 84, 78, 109, 85, 100);
		Pokemon Venusaur = new Pokemon("Venusaur", 3, "GRASS", "POISON", 80, 82, 83, 100, 100, 80);
		
//		Charizard MoveSet
		Move AirSlash = new SpecialMove("Air Slash", "FLYING", 75, 95);
		Move DragonClaw = new PhysicalMove("Dragon Claw", "DRAGON", 80, 100);
		Move Ember = new SpecialMove("Ember", "FIRE", 40, 100);
		Move SmokeScreen = new StatusMove("SmokeScreen", "NORMAL", 100);
//		Venusaur MoveSet
		Move PetalBlizzard = new PhysicalMove("Petal Blizzard", "GRASS", 90, 100);
		Move Growl = new StatusMove("Growl", "NORMAL", 100);
		Move Tackle = new PhysicalMove("Tackle", "NORMAL", 40, 100);
		Move VineWhip = new PhysicalMove("Vine Whip", "GRASS", 45, 100);
		
		// Create 2 OwnedPokemon objects
		// Variables in order: Pokemon base, int level, Move[] moves
		Move[] charizardMoves = {AirSlash, DragonClaw, Ember, SmokeScreen};
		OwnedPokemon charizard = new OwnedPokemon(Charizard, 88, charizardMoves);
		Move[] venusaurMoves = {PetalBlizzard, Growl, Tackle, VineWhip};
		OwnedPokemon venusaur = new OwnedPokemon(Venusaur, venusaurMoves);
		
		// Call printInfo() on each OwnedPokemon object to display their computed stats
		charizard.printInfo();
		venusaur.printInfo();
		
		// Call setLevel() to change one OwnedPokemon's level, then call printInfo() again and confirm the stats changed
		venusaur.setLevel(67);
		venusaur.printInfo();
		
		// Call setCurrentHp(0) on one OwnedPokemon and use isFainted() to confirm it returns true
		venusaur.setCurrentHp(0);
		System.out.println("Is venusaur fainted? " + venusaur.isFainted());
		
		
		
		
		
		// Code below is not requested in part 2 and is left over from part 1's extension
		
		
		
		
		
		
		
//		Add Both to Collection ArrayList
		Collection.add(Charizard);
		Collection.add(Venusaur);
		
		/*
		 * Declare + Initialize Moves Variables in order: Name Type Power Accuracy
		 * Category
		 */

//		Add all moves to collection. 
		Moves.add(AirSlash);
		Moves.add(DragonClaw);
		Moves.add(Ember);
		Moves.add(SmokeScreen);
		Moves.add(PetalBlizzard);
		Moves.add(Growl);
		Moves.add(Tackle);
		Moves.add(VineWhip);

//		Print out Values with getters, change 1 value and print again
		System.out.println("Charziard's attack: " + Charizard.getAtk());
		System.out.println("Charziard's defense: " + Charizard.getDef());
		// Set different value, print again to verify
		Charizard.setAtk(88);
		System.out.println("Charziard's attack after setting different value: " + Charizard.getAtk());
		System.out.println();
		
		for (Pokemon i : Collection) {
			i.printInfo();
			System.out.println();
		}
		for (Move i : Moves) {
			i.printInfo();
			System.out.println();
		}
	}

}
