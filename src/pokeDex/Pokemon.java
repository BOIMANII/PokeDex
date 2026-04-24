package pokeDex;

public class Pokemon {
	private String name;
	private int pokedex;
	private Type type1;
	private Type type2;
	private int hp;
	private int atk;
	private int def;
	private int spA;
	private int spD;
	private int spe;
	
	//Construction 
	public Pokemon(String name, int pokedex, Type type1, Type type2, int hp, int atk, int def, int spA, int spD, int spe) {
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
	public Pokemon(String name, int pokedex, Type type1, int hp, int atk, int def, int spA, int spD, int spe) {
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
	public Type getType1() { return type1;}
	public Type getType2() { return type2;}
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

	public void setType1(Type type1) {
		this.type1 = type1;//Temporary. Reminder to fix data valadation later
	}

	public void setType2(Type type2) {
		this.type2 = type2; //Temporary. Reminder to fix data valadation later
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
	
	// Prints out pokemon information in rows. 
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