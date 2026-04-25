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

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		// Declare + Initialize Pokemons
		// Variable in order: Name PokeDex Type1 Type2 hp attack defense spA spD spE
		Pokemon charizard = new Pokemon("Charizard", 6, Type.FIRE, Type.FLYING, 78, 84, 78, 109, 85, 100);
		Pokemon venusaur = new Pokemon("Venusaur", 3, Type.GRASS, Type.POISON, 80, 82, 83, 100, 100, 80);
		Pokemon wartortle = new Pokemon("Wartortle", 8, Type.WATER, 59, 63, 80, 65, 80, 58);
		Pokemon pikachu = new Pokemon("Pikachu", 25, Type.ELECTRIC, 35, 55, 40, 50, 50, 90);
		Pokemon arbok = new Pokemon("Arbok", 24, Type.POISON, 60, 95, 69, 65, 79, 80);
		Pokemon slowBro = new Pokemon("Slowbro", 80, Type.WATER, Type.PSYCHIC, 95, 75, 110, 100, 80, 30);

		// Charizard move set
		Move airSlash = new SpecialMove("Air Slash", Type.FLYING, 75, 95);
		Move dragonClaw = new PhysicalMove("Dragon Claw", Type.DRAGON, 80, 100);
		Move ember = new SpecialMove("Ember", Type.FIRE, 40, 100);
		Move smokeScreen = new StatusMove("Smoke Screen", Type.NORMAL, 100);
		// Venusaur move set
		Move petalBlizzard = new PhysicalMove("Petal Blizzard", Type.GRASS, 90, 100);
		Move poisonPowder = new StatusMove("Poison Powder", Type.POISON, 100, StatusCondition.POISONED, 1, false);
		Move sludgeWave = new SpecialMove("Sludge Wave", Type.POISON, 95, 100);
		Move vineWhip = new PhysicalMove("Vine Whip", Type.GRASS, 45, 100);
		// Wartortle move set
		Move tackle = new PhysicalMove("Tackle", Type.NORMAL, 40, 100);
		Move icyWind = new SpecialMove("Icy Wind", Type.ICE, 55, 95, "spe", -1, 1, false);
		Move waterGun = new SpecialMove("Water Gun", Type.WATER, 40, 100);
		// Steel is a gen 2 type but since it doesn't matter here I'll just put normal
		Move ironDefense = new StatusMove("Iron Defense", Type.NORMAL, 100, "def", 2, 1, true);
		// Pikachu move set
		Move growl = new StatusMove("Growl", Type.NORMAL, 100, "atk", -1, 1, false);
		Move thunderBolt = new SpecialMove("Thunder Bolt", Type.ELECTRIC, 90, 100, StatusCondition.PARALYZED, 0.1, false);
		Move spark = new SpecialMove("Spark", Type.ELECTRIC, 65, 100, StatusCondition.PARALYZED, 0.3, false);
		// Tackle is also one of pikachu's moves
		// Arbok move set
		// Tackle is also one of arbok's moves
		Move leer = new StatusMove("Leer", Type.NORMAL, 100, "def", -1, 1, false);
		Move acidSpray = new SpecialMove("Acid Spray", Type.POISON, 40, 100, "def", -2, 1, false);
		Move screech = new StatusMove("Screech", Type.NORMAL, 85, "def", -2, 1, false);
		// Slowbro's move set
		// Slowbro also uses tackle
		Move zenHeadbutt = new PhysicalMove("Zen Headbutt", Type.PSYCHIC, 80, 90);
		Move psychic = new SpecialMove("Psychic", Type.PSYCHIC, 90, 100);
		Move surf = new SpecialMove("Surf", Type.WATER, 90, 100);
		
		// Create 6 OwnedPokemon objects
		// Variables in order: Pokemon base, int level, Move[] moves
		Move[] charizardMoves = {airSlash, dragonClaw, ember, smokeScreen};
		OwnedPokemon ownedCharizard = new OwnedPokemon(charizard, charizardMoves);
		Move[] venusaurMoves = {petalBlizzard, poisonPowder, sludgeWave, vineWhip};
		OwnedPokemon ownedVenusaur = new OwnedPokemon(venusaur, venusaurMoves);
		Move[] wartortleMoves = {tackle, icyWind, waterGun, ironDefense};
		OwnedPokemon ownedWartortle = new OwnedPokemon(wartortle, wartortleMoves);
		Move[] pikachuMoves = {growl, thunderBolt, spark, tackle};
		OwnedPokemon ownedPikachu = new OwnedPokemon(pikachu, pikachuMoves);
		Move[] arbokMoves = {tackle, leer, acidSpray, screech};
		OwnedPokemon ownedArbok = new OwnedPokemon(arbok, arbokMoves);
		Move[] slowbroMoves = {tackle, zenHeadbutt, psychic, surf};
		OwnedPokemon ownedSlowbro = new OwnedPokemon(slowBro, slowbroMoves);
		
		Scanner sc = new Scanner(System.in);
		
		// Get game set up
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		
		// Let player choose 3 pokemon
		ArrayList<OwnedPokemon> computerPokemonsList = new ArrayList<>();
		computerPokemonsList.add(ownedCharizard);
		computerPokemonsList.add(ownedVenusaur);
		computerPokemonsList.add(ownedWartortle);
		computerPokemonsList.add(ownedPikachu);
		computerPokemonsList.add(ownedArbok);
		computerPokemonsList.add(ownedSlowbro);
		ArrayList<OwnedPokemon> playerPokemonsList = new ArrayList<>();
		ArrayList<Integer> alreadyChosen = new ArrayList<>();
		while(!(alreadyChosen.size() == 3)) {
			System.out.println("Pokemon:");
			System.out.println("1. Charizard");
			System.out.println("2. Venusaur");
			System.out.println("3. Wartortle");
			System.out.println("4. Pikachu");
			System.out.println("5. Arbok");
			System.out.println("6. Slowbro");
			System.out.print("Choose 3 pokemon (enter corresponding integer): ");
			int selection = 0;
			try {
				selection = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Invalid selection, try again");
			}
			if (selection == 1 && !alreadyChosen.contains(1)) {
				playerPokemonsList.add(ownedCharizard);
				computerPokemonsList.remove(ownedCharizard);
				alreadyChosen.add(1);
			} else if (selection == 2 && !alreadyChosen.contains(2)) {
				playerPokemonsList.add(ownedVenusaur);
				computerPokemonsList.remove(ownedVenusaur);
				alreadyChosen.add(2);
			} else if (selection == 3 && !alreadyChosen.contains(3)) {
				playerPokemonsList.add(ownedWartortle);
				computerPokemonsList.remove(ownedWartortle);
				alreadyChosen.add(3);
			} else if (selection == 4 && !alreadyChosen.contains(4)) {
				playerPokemonsList.add(ownedPikachu);
				computerPokemonsList.remove(ownedPikachu);
				alreadyChosen.add(4);
			} else if (selection == 5 && !alreadyChosen.contains(5)) {
				playerPokemonsList.add(ownedArbok);
				computerPokemonsList.remove(ownedArbok);
				alreadyChosen.add(5);
			} else if (selection == 6 && !alreadyChosen.contains(6)) {
				playerPokemonsList.add(ownedSlowbro);
				computerPokemonsList.remove(ownedSlowbro);
				alreadyChosen.add(6);
			} else {
				System.out.println("Invalid selection - try again");
			}
		}
		
		OwnedPokemon[] playerPokemons = convertToArray(playerPokemonsList);
		OwnedPokemon[] computerPokemons = convertToArray(computerPokemonsList);
		
		Trainer player = new Trainer(name, playerPokemons);
		Trainer computer = new Trainer(name, computerPokemons);
		
		BattleEngine battle = new BattleEngine(player, computer);
		battle.startBattle();
		
		sc.close();
		
	}
	
	/**
	 * Converts an arraylist of OwnedPokemon to a normal OwnedPokemon[] array
	 * Only works properly when there are 3 OwnedPokemon in the arraylist, post selection in main
	 * 
	 * @param ArrayList<OwnedPokemon> pokemonsList
	 * @return OwnedPokemon[]
	 */
	public static OwnedPokemon[] convertToArray(ArrayList<OwnedPokemon> pokemonsList) {
		OwnedPokemon[] pokemons = new OwnedPokemon[3];
		for (int i = 0; i < 3; i++) {
			pokemons[i] = pokemonsList.get(i);
		}
		return pokemons;
	}

}
