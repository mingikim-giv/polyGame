package polyGame;

public class UnitSeren extends Unit {
	public static UnitSeren instance = new UnitSeren();

	public Unit add() {
	  this.name = "세렌";
	  this.maxHp = 600;
	  this.power = 40;
	  Unit temp = new Unit(name, maxHp, power, new PaladinSkill());
	  return temp;
	}
}