package polyGame;

public class Paladin extends Unit {
	public static Paladin instance = new Paladin();
	
	  public Unit add() {
		  this.name = "팔라딘";
		  this.maxHp = 1000;
		  this.power = 50;
		  Unit temp = new Unit(name, maxHp, power);
		  return temp;
	  }
}
