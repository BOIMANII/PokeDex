package pokemon;

// Enumerates the major status conditions used in battle.
public enum StatusCondition {
    NONE("OK"), 
    PARALYZED("Paralyzed"), //25% speed
    BURNED("Burned"), // Loses 1/16 max HP and Physical Move damage is halved
    POISONED("Poisoned"),// Loses 1/16 max HP
    ASLEEP("Asleep");// Cannot move for 1-3 turns randomly generated

    private final String displayName;

    // Stores the user-facing label for the status.
    StatusCondition(String displayName) {
        this.displayName = displayName;
    }

    // Returns the readable label for this status.
    public String getDisplayName() {
        return displayName;
    }
}