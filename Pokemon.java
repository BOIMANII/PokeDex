package pokeDex;

public class Pokemon {
	private String name;
	private int pokedex;
	private String type1;
	private String type2;
	private int hp;
	private int atk;
	private int def;
	private int spA;
	private int spD;
	private int spe;
	
	//Construction 
	public Pokemon(String name, int pokedex, String type1, String type2, int hp, int atk, int def, int spA, int spD, int spe) {
		setName(name);
		setDex(pokedex);
		setType1(type1);
		setType2(type2);
		setHp(hp);
		setAtk(atk);
		setDef(def);
		setSpA(spA);
		setSpD(spD);
		setSpe(spe);
	}
	public Pokemon(String name, int pokedex, String type1, int hp, int atk, int def, int spA, int spD, int spe) {
		this.name = name;
		this.pokedex = pokedex;
		this.type1 = type1;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.spA = spA;
		this.spD = spD;
		this.spe = spe;
	}
	
	//Getters
	public String getName() { return name;}
	public int getDex() { return pokedex;}
	public String getType1() { return type1;}
	public String getType2() { return type2;}
	public int getHp() { return hp;}
	public int getAtk() { return atk;}
	public int getDef() { return def;}
	public int getSpA() { return spA;}
	public int getSpD() { return spD;}
	public int getSpe() { return spe;}
	
	//Setters
	public void setName(String name) {
	    this.name = name;
	}

	public void setDex(int pokedex) {
		if(pokedex <= 0) {
			System.out.println("setDex invalid input: Negitive Number");
			return;
		}
	    this.pokedex = pokedex;
	}

	public void setType1(String type1) {
		String[] types = {"NORMAL", "FIRE", "WATER", "GRASS", "ELECTRIC", "ICE", "FIGHTING", "POISON", "GROUND", "FLYING", "PSYCHIC", "BUG", "ROCK", "GHOST", "DRAGON", "STEEL", "DARK", "Fairy"};
		for (String type : types) {
			if (type.equalsIgnoreCase(type1)) {
				this.type1 = type1;
				return;
			}
		}
		System.out.println("Invalid type entry: Must choose from existing types");
	}

	public void setType2(String type2) {
		String[] types = {"NORMAL", "FIRE", "WATER", "GRASS", "ELECTRIC", "ICE", "FIGHTING", "POISON", "GROUND", "FLYING", "PSYCHIC", "BUG", "ROCK", "GHOST", "DRAGON", "STEEL", "DARK", "Fairy"};
		for (String type : types) {
			if (type.equalsIgnoreCase(type2)) {
				this.type2 = type2;
				return;
			}
		}
		System.out.println("Invalid type entry: Must choose from existing types");
	}

	public void setHp(int hp) {
		if(hp <= 0) {
			System.out.println("setHp invalid input: Negitive Number");
			return;
		}
	    this.hp = hp;
	}

	public void setAtk(int atk) {
		if(atk <= 0) {
			System.out.println("setAtk invalid input: Negitive Number");
			return;
		}
	    this.atk = atk;
	}

	public void setDef(int def) {
		if(def <= 0) {
			System.out.println("setDef invalid input: Negitive Number");
			return;
		}
	    this.def = def;
	}

	public void setSpA(int spA) {
		if(spA <= 0) {
			System.out.println("setSpA invalid input: Negitive Number");
			return;
		}
	    this.spA = spA;
	}

	public void setSpD(int spD) {
		if(spD <= 0) {
			System.out.println("setSpD invalid input: Negitive Number");
			return;
		}
	    this.spD = spD;
	}

	public void setSpe(int spe) {
		if(spe <= 0) {
			System.out.println("setSpe invalid input: Negitive Number");
			return;
		}
	    this.spe = spe;
	}
	
	/**
	 * Prints out pokemon information in rows. 
	 * 
	 * @param
	 * @return
	 */
	public void printInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Index: " + this.pokedex);
		System.out.println("Type 1: " + this.type1);			
		System.out.println("Type 2: " + this.type2);
		System.out.println("Attack: " + this.atk);
		System.out.println("Defense: " + this.def);
		System.out.println("Special Attack: " + this.spA);
		System.out.println("Special Defense: " + this.spD);
		System.out.println("Special Speed: " + this.spe);
	}
	
}