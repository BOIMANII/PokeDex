/**
 * @author Max
 * @date 2026-04-24
 * @teacher Steve Smintich
 * 
 * This class handles the logic for damage calculation, turn order, and the overall game loop.
 */

package pokeDex;

import java.util.Scanner;
import java.util.Random;

public class BattleEngine {
	
	private Trainer player;
	
	private Trainer computer;
	
	private static Scanner sc = new Scanner(System.in);
	private Random rand = new Random();
	
	// Constructor: Takes a Trainer player and a Trainer computer. Initialize the Scanner (e.g., new 
	// Scanner(System. in)).
	public BattleEngine(Trainer player, Trainer computer) {
		this.player = player;
		this.computer = computer;
	}
	
	/**
	 * Calculates the damage an attack does
	 * damage = ((2 * level / 5 + 2) * power * effectiveAtk / effectiveDef) / 50 + 2
	 * Physical moves use attack and defense, special moves use special attack and special defense
	 * Calculated damage is then multiplied by 1, 1/2 or 2 depending on the type of attack and the target 
	 * pokemon's defense
	 * 
	 * @param OwnedPokemon attacker
	 * @param Move move
	 * @param OwnedPokemon defender
	 * @return int
	 */
	public int calculateDamage(OwnedPokemon attacker, Move move, OwnedPokemon defender) {
		int attack = 0;
		int defense = 0;
		if (move.getCategory().equals("Physical")) {
			attack = attacker.getEffectiveAtk();
			defense = defender.getEffectiveDef();
		} else if (move.getCategory().equals("Special")) {
			attack = attacker.getCurrentSpA();
			defense = defender.getCurrentSpD();
		}
		
		int damage = ((((2 * attacker.getLevel() / 5) + 2) * move.getPower() * attack )/ defense) / 50 + 2;
		
		double effectiveness1 = Type.getEffectiveness(move.getType(), defender.getBase().getType1());
		double effectiveness2 = 1;
		if (defender.getBase().getType2() == Type.NONE) {
			effectiveness2 = Type.getEffectiveness(move.getType(), defender.getBase().getType2());
		}
		damage = (int) (damage * effectiveness1 * effectiveness2);
		
		return damage;
		
	}
	
	/**
	 * Executes an attack
	 * First checks to see if attack can be made, then deals damage if not a status move and then calls 
	 * applyMoveEffect()
	 * 
	 * @param OwnedPokemon attacker
	 * @param Move move
	 * @param OwnedPokemon defender
	 * @return void
	 */
	public void executeAttack(OwnedPokemon attacker, Move move, OwnedPokemon defender) {
		
		// Check if move can be made (attacker cannot be asleep or in paralysis)
		boolean canAttack = true;
		if (attacker.getSleepCounter() != 0) {
			canAttack = false;
			System.out.println("The attack fails because " + attacker.getBase().getName() + " is asleep");
		} else if (attacker.getStatus() == StatusCondition.PARALYZED) {
			if (rand.nextInt(0, 4) == 0) {
				canAttack = false;
				System.out.println("The attack fails because " + attacker.getBase().getName() + " is paralyzed");
			}
		}
		
		if(!(rand.nextInt(1, 101) <= move.getAccuracy())) {
			System.out.println("The attack misses!");
			canAttack = false;
		}
		
		// Execute attack if attack can be/is made
		if (canAttack == true) {
			if (move.getCategory().equals("Physical") || move.getCategory().equals("Special")) {
				int damage = calculateDamage(attacker, move, defender);
				defender.setCurrentHp(defender.getCurrentHp() - damage);
			}
			applyMoveEffect(attacker, move, defender);
		}
		
	}
	
	/**
	 * Applies the move's non-damage effects: Applies status and stat changes appropriately
	 * 
	 * @param OwnedPokemon user
	 * @param Move move
	 * @param OwnedPokemon target
	 * @return void
	 */
	public void applyMoveEffect(OwnedPokemon user, Move move, OwnedPokemon target) {
		
		// Status conditions
		if (move.getStatusChance() > 0) {
			if (rand.nextDouble(0, 1) <= move.getStatusChance()) {
				if (move.isStatAffectsUser()) {
					user.applyStatus(move.getStatus());
					System.out.println(user.getBase().getName() + " is " + move.getStatus().getDisplayName());
				} else {
					target.applyStatus(move.getStatus());
					System.out.println(target.getBase().getName() + " is " + move.getStatus().getDisplayName());
				}
			}
		}
		
		// Stat changes
		if (move.getStatAffected() != null) {
			if (move.isStatAffectsUser()) {
				user.applyStatChange(move.getStatAffected(), move.getStatStages());
				// Display an accurate one line comment on stat changes if applicable
				if (move.getStatStages() > 0) {
					System.out.println(user.getBase().getName() + "'s " + move.getStatAffected() + " rose");
				} else if (move.getStatStages() < 0) {
					System.out.println(user.getBase().getName() + "'s " + move.getStatAffected() + " fell");
				}
			} else {
				target.applyStatChange(move.getStatAffected(), move.getStatStages());
				// Display an accurate one line comment on stat changes if applicable
				if (move.getStatStages() > 0) {
					System.out.println(target.getBase().getName() + "'s " + move.getStatAffected() + " rose");
				} else if (move.getStatStages() < 0) {
					System.out.println(target.getBase().getName() + "'s " + move.getStatAffected() + " fell");
				}
			}
		}
		
	}
	
	/**
	 * Executes one turn after taking in both pokemon's attacks
	 * 
	 * @param Move playerMove
	 * @param OwnedPokemon playermon
	 * @param Move computerMove
	 * @param OwnedPokemon computermon
	 * @return void
	 */
	public void executeTurn (Move playerMove,Move computerMove) {
		
		// Compare speeds to determine first and second pokemon - true means player's attack is faster
		boolean faster;
		if (player.getActivePokemon().getEffectiveSpe() > computer.getActivePokemon().getEffectiveSpe()) {
			faster = true;
		} else if (player.getActivePokemon().getEffectiveSpe() == computer.getActivePokemon().getEffectiveSpe()) {
			if (rand.nextInt(0,2) == 0) {
				faster = true;
			} else {
				faster = false;
			}
		} else {
			faster = false;
		}
		
		// Execute player's attack first if they are faster
		if (faster == true) {
			// Player first
			executeAttack(player.getActivePokemon(), playerMove, computer.getActivePokemon());
			if (computer.getActivePokemon().isFainted() && computer.hasLost() == false) {
				System.out.println(computer.getActivePokemon().getBase().getName() + " has fainted - switching pokemon");
				computer.switchToNext();
				applyEndOfTurnEffects(player.getActivePokemon(), player);
				// TODO - if you kill the opponent before they attack, is it the end of the turn? (assuming yes)
				return;
			} else if (computer.getActivePokemon().isFainted() && computer.hasLost()) {
				System.out.println(computer.getActivePokemon().getBase().getName() + " has fainted - you win!");
				return;
			}
			// Computer next, assuming they survive
			executeAttack(computer.getActivePokemon(), computerMove, player.getActivePokemon());
			if (player.getActivePokemon().isFainted() && player.hasLost() == false) {
				System.out.println(player.getActivePokemon().getBase().getName() + " has fainted - switching pokemon");
				player.switchToNext();
			} else if (player.getActivePokemon().isFainted() && player.hasLost()) {
				System.out.println(player.getActivePokemon().getBase().getName() + " has fainted - computer wins!");
			}
		// Execute computer first turn if applicable
		} else {
			// Computer first
			executeAttack(computer.getActivePokemon(), computerMove, player.getActivePokemon());
			if (player.getActivePokemon().isFainted() && player.hasLost() == false) {
				System.out.println(player.getActivePokemon().getBase().getName() + " has fainted - switching pokemon");
				player.switchToNext();
				
				// TODO - if you kill the opponent before they attack, is it the end of the
				// turn? (assuming yes)
				
				applyEndOfTurnEffects(computer.getActivePokemon(), computer);
				return;
			} else if (player.getActivePokemon().isFainted() && player.hasLost()) {
				System.out.println(player.getActivePokemon().getBase().getName() + " has fainted - computer wins!");
				return;
			}
			// Player next, assuming they survive
			executeAttack(player.getActivePokemon(), playerMove, computer.getActivePokemon());
			if (computer.getActivePokemon().isFainted() && computer.hasLost() == false) {
				System.out.println(computer.getActivePokemon().getBase().getName() + " has fainted - switching pokemon");
				computer.switchToNext();
			} else if (computer.getActivePokemon().isFainted() && computer.hasLost()) {
				System.out.println(computer.getActivePokemon().getBase().getName() + " has fainted - you win!");
			}
			
		}
		
		// applyEndOfTurnEffects() on both active Pokémon
		applyEndOfTurnEffects(player.getActivePokemon(), player);
		applyEndOfTurnEffects(computer.getActivePokemon(), computer);
		
	}
	
	/**
	 * Applies end of turn updates to pokemon based on status conditions
	 * 
	 * @param OwnedPokemon pokemon
	 * @param Trainer trainer
	 * @return void
	 */
	public void applyEndOfTurnEffects(OwnedPokemon pokemon, Trainer trainer) {
		// The burned status condition causes pokemon to lose 1/16 of their full HP at the end of each turn
		// So does the poisoned status, which I am including as a part of the end of turn effects
		if (pokemon.getStatus() == StatusCondition.BURNED || pokemon.getStatus() == StatusCondition.POISONED) {
			int damage = pokemon.getMaxHp() / 16;
			pokemon.setCurrentHp(pokemon.getCurrentHp() - damage);
			System.out.println(pokemon.getBase().getName() + " was " + pokemon.getStatus().getDisplayName());
			if (pokemon.isFainted() && trainer.hasLost() == false) {
				System.out.println(pokemon.getBase().getName() + " has fainted - switching pokemon");
				trainer.switchToNext();
			} else if (pokemon.isFainted() && trainer.hasLost()) {
				if (trainer.getName().equalsIgnoreCase("computer")) {
					System.out.println(trainer.getActivePokemon().getBase().getName() + " has fainted - you win!");
				} else {
					System.out.println(trainer.getActivePokemon().getBase().getName() + " has fainted - computer wins!");
				}
			}
		} else if (pokemon.getStatus() == StatusCondition.ASLEEP && pokemon.getSleepCounter() > 0) {
			pokemon.setSleepCounter(pokemon.getSleepCounter() - 1);
			if (pokemon.getSleepCounter() == 0) {
				pokemon.applyStatus(StatusCondition.NONE);
				System.out.println(pokemon.getBase().getName() + " woke up");
			}
		}
	}
	
	/**
	 * Is the method called in Main to run the game
	 * Will take both trainers and keep running executeTurn until one trainer loses
	 * Trainers must be fully initialized (with the pokemon they train)
	 * 
	 * @return void
	 */
	public void startBattle() {
		boolean first = true;
		while (player.hasLost() == false && computer.hasLost() == false) {
			if (first == true) {
				computer.getActivePokemon().printInfo();
				player.getActivePokemon().printInfo();
			}
			System.out.print("Enter which move you want to do (please enter an integer 1 - 4): ");
			int selection = newSelection(first);
			first = false;
			System.out.println();
			if (selection != 0) {
				Move playerSelection = player.getActivePokemon().getMoves()[selection - 1];
				Move computerSelection = computer.getActivePokemon().getMoves()[rand.nextInt(0,4)];
				executeTurn(playerSelection, computerSelection);
			}
			computer.getActivePokemon().printInfo();
			player.getActivePokemon().printInfo();
		}
	}
	
	/**
	 * Lets user enter selection and does data verification
	 * Returns 0 if invalid selection is made (if it is invalid, or already chosen, or out of bounds)
	 * Otherwise returns the selection
	 * Requires a list of selections already made as well as a boolean describing if it is the first time this is called or not
	 * (For purposes of clearing the scanner before reaching it)
	 * 
	 * @param ArrayList<Integer> alreadyChosen
	 * @param boolean first
	 * @return
	 */
	public static int newSelection(boolean first) {
		int selection = 0;
		try {
			if (first == false) {
				sc.nextLine();
			}
			selection = sc.nextInt();
			if (selection < 1 || selection > 4) {
				System.out.println("Out of bounds");
				return 0;
			}
		} catch (Exception e) {
			System.out.println("Invalid selection, try again");
			return 0;
		}
		return selection;
	}

}
