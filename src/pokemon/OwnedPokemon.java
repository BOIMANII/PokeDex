package pokemon;

import moves.Move;

public class OwnedPokemon implements Printable {

    private Pokemon base;
    private int level;
    private Move[] moves;
    private int maxHp, currentHp;
    private int currentAtk, currentDef, currentSpA, currentSpD, currentSpe;

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

    // Private, uses formula to calculate stats, has exclusive formula for maxHp.
    private void recalculateStats() {
        this.maxHp      = (2 * base.getHp()  * level) / 100 + level + 10;
        this.currentHp  = this.maxHp; // sets current to max
        this.currentAtk = (2 * base.getAtk() * level) / 100 + 5;
        this.currentDef = (2 * base.getDef() * level) / 100 + 5;
        this.currentSpA = (2 * base.getSpA() * level) / 100 + 5;
        this.currentSpD = (2 * base.getSpD() * level) / 100 + 5;
        this.currentSpe = (2 * base.getSpe() * level) / 100 + 5;
    }

    @Override
    public void printInfo() {
        System.out.println("--- Pokemon Info ---");
        System.out.println("Name     : " + base.getName());
        System.out.println("Level    : " + level);
        System.out.println("Type     : " + base.getType1());

        // Build move name list
        System.out.print("Moves    : ");
        for (int i = 0; i < moves.length; i++) {
            System.out.print(moves[i].getName());
            if (i < moves.length - 1) System.out.print(", ");
        }
        System.out.println();

        System.out.println("HP       : " + currentHp + " / " + maxHp);
        System.out.println("Attack   : " + currentAtk);
        System.out.println("Defense  : " + currentDef);
        System.out.println("Sp. Atk  : " + currentSpA);
        System.out.println("Sp. Def  : " + currentSpD);
        System.out.println("Speed    : " + currentSpe);
    }

    // Getters
    public Pokemon getBase()     { return base; }
    public int getLevel()        { return level; }
    public Move[] getMoves()     { return moves; }
    public int getMaxHp()        { return maxHp; }
    public int getCurrentHp()    { return currentHp; }
    public int getCurrentAtk()   { return currentAtk; }
    public int getCurrentDef()   { return currentDef; }
    public int getCurrentSpA()   { return currentSpA; }
    public int getCurrentSpD()   { return currentSpD; }
    public int getCurrentSpe()   { return currentSpe; }

    // setCurrentHp, validation within bounds
    public void setCurrentHp(int hp) {
        if (hp < 0)          this.currentHp = 0;
        else if (hp > maxHp) this.currentHp = maxHp;
        else                 this.currentHp = hp;
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

    public boolean isFainted() {
        return currentHp == 0;
    }
}