package creatures;

import java.util.Random;

//Define the Parent Class here
abstract public class Creature { 

	// Fields
	public String name;
	public int health;
	public int attackPower;

	// methods
	public boolean isAlive(Object a) {
		return this.health > 0;
		//return this.attackPower > 0;
	}

	// abstract method has no body
	abstract public void takeDamage(int damage);
	abstract public void attack(Creature things);

	// This is my Main method
	public static void main(String[] args) {
		Creature[] creatures = new Creature[4];
		creatures[0] = new Rat();
		creatures[1] = new Ogre();
		creatures[2] = new Goblin();
		creatures[3] = new Hero();
		creatures[3].attack(creatures[1]);
		creatures[3].attack(creatures[0]);
		creatures[3].attack(creatures[2]);
		creatures[1].takeDamage(3);
		System.out.println(creatures[0].name);
		System.out.println(creatures[1].name);
		System.out.println(creatures[2].name);
		System.out.println(creatures[3].name);
		System.out.println(creatures[3].attackPower);
		System.out.println(creatures[0].attackPower);
		System.out.println(creatures[2].attackPower);
	
		 Random r = new Random();
		// double d = r.nextDouble();
		 Creature c = new Ogre();
		 c.takeDamage(35);
		 c = new Rat();
		 c.takeDamage(90);
		 c.takeDamage(18);
				 System.out.println(c.isAlive(creatures));
		 Object a = 0;
		System.out.println(c.isAlive(a));
	}
}

// Rat is a Child of Creature
class Rat extends Creature {
	public int bite;
	public int smell;

	// constructor
	public Rat() {
		this.health = 6;
		this.name = "Moe";
		this.attackPower = 10;
	}

	// method
	public void takeDamage(int damage) {
		this.health -= damage;
		System.out.println(this.health);
	}

	// method
	public void attack(Creature attack) {
		this.attackPower -=  2;
//		System.out.println(this.health);
		System.out.println("Way to go!");
	}	
}

// Ogre is a Child of Creature
class Ogre extends Creature {
	public int size;

	// constructor
	public Ogre() {
		this.health = 35;
		this.name = "Curly";
		this.attackPower = 20;
	}

	// method
	public void takeDamage(int damage) {
		this.health -= damage / 2;
		System.out.println(this.health);
	}

	// method
	public void attack(Creature c) {
		c.takeDamage(this.attackPower * 2);
		System.out.println("Hey");
	}
}

// Goblin is a Child of Creature
class Goblin extends Creature {

	// constructor
		public Goblin() {
			this.health = 60;
			this.name = "Larry";
			this.attackPower = 25;
		}
	
	// method
	public void takeDamage(int damage) {
		System.out.println(this.health);
		this.health -= damage;
		
		System.out.println(damage);
		System.out.println(this.health);
		
	}

	// methods
	public void attack(Creature c) {  //Body
		c.takeDamage(this.attackPower + 4);
		System.out.println("Hello!");
	}
}

class Hero extends Creature {
	
	// constructor
	public Hero() {
	this.health = 13;
	this.name = "Bob";
	this.attackPower = 15;
	Creature c = null;

	}
	
	// method
	public void fight(Creature[] creatures) {
		this.fight(creatures);

	}

	// method
	public void takeDamage(int damage) {

	}

	// method
	public void attack(Creature c) {
		c.takeDamage(this.attackPower);
		System.out.println("done");
	}
}
