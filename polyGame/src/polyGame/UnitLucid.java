package polyGame;

public class UnitLucid extends Unit {
	public static UnitLucid instance = new UnitLucid();
	
	public Unit add() {
	  this.name = "루시드";
	  this.maxHp = 400;
	  this.power = 30;
	  Unit temp = new Unit(name, maxHp, power, new LucidSkill());
	  return temp;
	}
}