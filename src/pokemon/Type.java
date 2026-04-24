package pokemon;
// DO NOT ALTER PER INSTRUCTIONS
// Defines Pokemon types and the effectiveness multipliers between them.
public enum Type {
    NORMAL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    ICE,
    FIGHTING,
    POISON,
    GROUND,
    FLYING,
    PSYCHIC,
    BUG,
    ROCK,
    GHOST,
    DRAGON,
    NONE;

    private static final double[][] CHART = buildChart();

    // Builds the type chart once when the enum loads.
    private static double[][] buildChart() {
        int size = values().length;
        double[][] chart = new double[size][size];

        // Start every matchup as neutral.
        for (int attacker = 0; attacker < size; attacker++) {
            for (int defender = 0; defender < size; defender++) {
                chart[attacker][defender] = 1.0;
            }
        }

        for (Type attacker : values()) {
            chart[attacker.ordinal()][NONE.ordinal()] = 1.0;
            chart[NONE.ordinal()][attacker.ordinal()] = 1.0;
        }

        // Only the matchup overrides needed by this project are listed here.
        set(chart, FIRE, 2.0, GRASS, ICE, BUG);
        set(chart, FIRE, 0.5, FIRE, WATER, ROCK, DRAGON);
        set(chart, WATER, 2.0, FIRE, GROUND, ROCK);
        set(chart, WATER, 0.5, WATER, GRASS, DRAGON);
        set(chart, GRASS, 2.0, WATER, GROUND, ROCK);
        set(chart, GRASS, 0.5, FIRE, GRASS, POISON, FLYING, BUG, DRAGON);
        set(chart, ELECTRIC, 2.0, WATER, FLYING);
        set(chart, ELECTRIC, 0.5, GRASS, ELECTRIC, DRAGON);
        set(chart, ELECTRIC, 0.0, GROUND);
        set(chart, ICE, 2.0, GRASS, GROUND, FLYING, DRAGON);
        set(chart, ICE, 0.5, WATER, ICE);
        set(chart, FIGHTING, 2.0, NORMAL, ICE, ROCK);
        set(chart, FIGHTING, 0.5, POISON, BUG, PSYCHIC, FLYING);
        set(chart, FIGHTING, 0.0, GHOST);
        set(chart, POISON, 2.0, GRASS, BUG);
        set(chart, POISON, 0.5, POISON, GROUND, ROCK, GHOST);
        set(chart, GROUND, 2.0, FIRE, ELECTRIC, POISON, ROCK);
        set(chart, GROUND, 0.5, GRASS, BUG);
        set(chart, GROUND, 0.0, FLYING);
        set(chart, FLYING, 2.0, GRASS, FIGHTING, BUG);
        set(chart, FLYING, 0.5, ELECTRIC, ROCK);
        set(chart, PSYCHIC, 2.0, FIGHTING, POISON);
        set(chart, PSYCHIC, 0.5, PSYCHIC);
        set(chart, PSYCHIC, 0.0, GHOST);
        set(chart, BUG, 2.0, GRASS, POISON, PSYCHIC);
        set(chart, BUG, 0.5, FIRE, FIGHTING, FLYING, GHOST);
        set(chart, ROCK, 2.0, FIRE, ICE, FLYING, BUG);
        set(chart, ROCK, 0.5, FIGHTING, GROUND);
        set(chart, GHOST, 2.0, GHOST);
        set(chart, GHOST, 0.0, NORMAL, PSYCHIC);
        set(chart, DRAGON, 2.0, DRAGON);
        set(chart, NORMAL, 0.5, ROCK);
        set(chart, NORMAL, 0.0, GHOST);

        return chart;
    }

    // Writes one multiplier across multiple defending types.
    private static void set(double[][] chart, Type attacker, double value, Type... defenders) {
        for (Type defender : defenders) {
            chart[attacker.ordinal()][defender.ordinal()] = value;
        }
    }

    // Returns the effectiveness multiplier for one attacking type against one defender.
    public static double getEffectiveness(Type attacking, Type defending) {
        return CHART[attacking.ordinal()][defending.ordinal()];
    }
}